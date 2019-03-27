package com.cjl.onrefectory.web.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjl.onrefectory.ex.BaseException;


public class MyFilterChain {
	private List<MyFilter> chain;
	private int index;
	public MyFilterChain() {
		chain = new ArrayList<MyFilter>();
		index = 0;
	}
	/**
	 * filter
	 * @param req
	 * @param resp
	 */
	public MyFilterChain addFilter(MyFilter filter) {
		chain.add(filter);
		return this;
	}
	public void doFilter(HttpServletRequest req,HttpServletResponse resp) throws BaseException {
		if(index >= chain.size())
			return;
		
		MyFilter filter = chain.get(index);
		index++;
		filter.doFilter(req, resp, this);
	}
}
