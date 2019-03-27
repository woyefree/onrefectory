package com.cjl.onrefectory.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {
	public void test(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.getWriter().print("hello world");
	}
}
