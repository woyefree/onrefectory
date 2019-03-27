package com.cjl.onrefectory.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjl.onrefectory.ex.BaseException;


public interface MyFilter {
	public void doFilter(HttpServletRequest req,HttpServletResponse resp,MyFilterChain chain) throws BaseException;
}
