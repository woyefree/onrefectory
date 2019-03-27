package com.cjl.onrefectory.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cjl.onrefectory.ex.BaseException;
import com.cjl.onrefectory.web.ApiResult;
import com.cjl.onrefectory.util.D;
import com.cjl.onrefectory.util.NameUtil;
import com.cjl.onrefectory.web.filter.LogFilter;
import com.cjl.onrefectory.web.filter.MyFilter;
import com.cjl.onrefectory.web.filter.MyFilterChain;
import com.cjl.onrefectory.web.filter.WhiteListFilter;


@WebServlet(urlPatterns= {"*.do","*.json"})
@MultipartConfig
public class WebApp extends HttpServlet	{
	private static final Logger log = Logger.getLogger(D.class);
	private static final String PROJECT_NAME = "/onrefectory/";
	private static final String CTR_PKG = "com.cjl.onrefectory.controller";
	private static ObjectMapper objMapper = new ObjectMapper();

	//http://localhost:8080/215/goods/add
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		
		String type = "do";
		if(uri.endsWith(".json")) {
			type = "json";
		}
		
		uri = uri.replace(PROJECT_NAME, "")
				 .replace(".do","")
				 .replace(".json","");
		String[] uris = uri.split("/");
		
		try {
			//构建过滤器
			MyFilterChain chain = new MyFilterChain();
			MyFilter logFilter = new LogFilter();
			MyFilter whiterListFilter = new WhiteListFilter();
			//MyFilter priviledgeFilter = new PriviledgeFilter();
			chain.addFilter(logFilter)
				 .addFilter(whiterListFilter);
				 //.addFilter(priviledgeFilter);
			//chain.doFilter(req, resp);
			
			if(uris.length < 2) {
				throw new RuntimeException("请求地址错误");
			}
			String className = CTR_PKG + "." + NameUtil.toCamel(uris[0],true) + "Controller";
			String methodName = NameUtil.toCamel(uris[1],false);
			
			Class clz = Class.forName(className);
			Object instance = clz.newInstance();
			Method method = clz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			Object returnResult = method.invoke(instance, req,resp);
			log.info("返回信息：" + returnResult);
			//把返回结果转发到指定页面
			if(returnResult != null) {
				//转发逻辑
				if(returnResult instanceof Result) {
					Result rs = (Result) returnResult;
					req.getRequestDispatcher(rs.getDispatchUrl()).forward(req,resp);
				}
				//跳转逻辑,重定向
				if(returnResult instanceof JumpResult) {
					JumpResult rs = (JumpResult) returnResult;
					resp.sendRedirect(rs.getJumpUrl());
				}
				//json处理
				if(returnResult instanceof ApiResult) {
					ApiResult rs = (ApiResult)returnResult;
					//返回json数据
					String rsStr = objMapper.writeValueAsString(rs);
					resp.getWriter().print(rsStr);
				}
			}
		}catch(NoSuchMethodException e) {
			//如果请求方法不存在，则直接渲染jsp页面
			req.getRequestDispatcher("/WEB-INF/jsp/" + uri + ".jsp").forward(req, resp);
		} catch (InvocationTargetException e) {
			Throwable target = e.getTargetException();
			
			if(target instanceof BaseException) {
				BaseException myException = (BaseException) target;
				
				//普通请求的异常处理
				if(type.equals("do")) {
					
					String pageName = uris[1].replace("do","").toLowerCase();
					
					String info = myException.getMessage();
					System.out.println(info);
					req.setAttribute("errInfo",info);
					log.info("返回：" + info);
					req.getRequestDispatcher("/WEB-INF/jsp/" + uris[0] + "/" + pageName + ".jsp").forward(req, resp);
				}
				
				//ajax的异常处理
				if(type.equals("json")) {
					ApiResult  rs = ApiResult.build();
					rs.setCode(myException.getCode());
					rs.setMsg(myException.getMessage());
					String rsStr = objMapper.writeValueAsString(rs);
					resp.getWriter().print(rsStr);
				}
				D.rollBack();
			} else {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
			//跳向500页面
			resp.sendError(500,e.getMessage());
			D.rollBack();
		} finally { 
			//关闭数据库连接
			D.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
