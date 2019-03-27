package com.cjl.onrefectory.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cjl.onrefectory.po.Admin;
import com.cjl.onrefectory.service.AdminService;
import com.cjl.onrefectory.service.AdminServiceImpl;
import com.cjl.onrefectory.util.UrlList;
import com.cjl.onrefectory.util.V;
import com.cjl.onrefectory.web.ApiResult;
import com.cjl.onrefectory.web.JumpResult;
import com.cjl.onrefectory.web.PageData;
import com.cjl.onrefectory.web.Result;
import com.cjl.onrefectory.ex.InvalidParamException;

public class AdminController {
	private AdminService adminService;
	private static Logger log = Logger.getLogger(AdminController.class);
	public AdminController() {
		adminService = new AdminServiceImpl();
	}
	/**
	 * 添加admin
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doAdd(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"name","pwd","gender","tel","role","email"};
		V.isEmpty(params);
		Admin admin = V.entity(req, Admin.class, params);
		adminService.save(admin);
		req.setAttribute("info", "添加成功");
		//转发的地址
		Result rs = Result.build().setDispatchUrl(UrlList.adminAdd);
		return rs;
	}
	/**
	 * 验证手机号是否存在
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult validTel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel"};
		V.isEmpty(params);
		String tel = req.getParameter("tel");
		Boolean hasExistTel = adminService.validTel(tel);
		//返回客户端的结果
		ApiResult ars = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExistTel);
		ars.setData(info);
		return ars;
	}
	/**
	 * 查看admin的列表
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doList(HttpServletRequest req,HttpServletResponse resp) {
		//接受页面传过来的数据
		String curPageStr = V.getData(req, "page", "1");
		String pageSizeStr = V.getData(req, "page_size", "2");
		String keyword = V.getData(req, "keyword", "");
		int curPage = Integer.parseInt(curPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		//开始进行查找
		PageData<Admin> admins = adminService.list(curPage, pageSize, keyword);
		req.setAttribute("admins", admins);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + admins);
		Result result = Result.build().setDispatchUrl(UrlList.adminList);
		return result;
		
	}
	/**
	 * 用户登录
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public JumpResult doLogin(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"tel","pwd"};
		V.isEmpty(params);
		Admin admin = V.entity(req, Admin.class, params);
		
		Admin existAdmin = adminService.login(admin);
		HttpSession session = req.getSession();
		session.setAttribute("admin",existAdmin);
		//req.setAttribute("userName",existAdmin.getName());
		JumpResult jResult = JumpResult.build().setJumpUrl(UrlList.home);
		return jResult;
	}
	/**
	 * 用户修改,主要展示要修改的信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public Result doEdit(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"id"};
		V.isEmpty(params);
		int id = Integer.parseInt(req.getParameter("id"));
		Admin admin = adminService.getAdminById(id);
		req.setAttribute("admin",admin);
		return Result.build().setDispatchUrl(UrlList.adminEdit);
	}
	/**
	 * 更新admin信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public ApiResult update(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"id","name","gender","tel","email"};
		String[] getParams = {"id","name","pwd","gender","tel","role","email"};
		V.isEmpty(params);
		Admin admin = V.entity(req, Admin.class, getParams);
		//调用service方法
		adminService.update(admin);
		return ApiResult.build();
	}
	/**
	 * 删除admin
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException 
	 */
	public ApiResult delete(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"id"};
		System.out.println(req.getParameter("id"));
		V.isEmpty(params);
		int id = Integer.parseInt(req.getParameter("id"));
		//调用service方法
		adminService.delete(id);
		return ApiResult.build();
	}
}
