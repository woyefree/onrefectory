package com.cjl.onrefectory.web.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cjl.onrefectory.ex.BaseException;

public class WhiteListFilter implements MyFilter{
	private static Logger log = Logger.getLogger(WhiteListFilter.class);
	
	private static List<String> whiteList = new ArrayList<String>();
	static {
		whiteList.add("/onrefectory/admin/doAdd.do");
		whiteList.add("/onrefectory/admin/doList.do");
		/*whiteList.add("teacher/validTel");
		whiteList.add("teacher/doLogin");
		whiteList.add("teacher/login");*/
	}
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, MyFilterChain chain) throws BaseException {
		String uri = (String) req.getAttribute("cur_url");
		
		if(whiteList.contains(uri)) {
			log.info("白名单验证通过，无需后继验证");
			return;
		}
		
		chain.doFilter(req, resp);
	}
	
}
