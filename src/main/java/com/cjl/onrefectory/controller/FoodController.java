package com.cjl.onrefectory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.cjl.onrefectory.po.Food;
import com.cjl.onrefectory.service.FoodService;
import com.cjl.onrefectory.service.FoodServiceImpl;
import com.cjl.onrefectory.util.V;

public class FoodController {
	private FoodService foodService;
	private static Logger log = Logger.getLogger(AdminController.class);
	public FoodController() {
		foodService = new FoodServiceImpl();
	}
	public void doAdd(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		String[] params = {"name","price","vipPrice","type","createTime","descc"};
		V.isEmpty(params);
		Food food = V.entity(req, Food.class, params);
		//img
		Part part = req.getPart("picture");
		
		
		//获取图片上传的根路径
		String uploadPath = req.getServletContext().getRealPath("/upload");
		//图片上传名
		uploadPath += "/1.jpg";
		part.write(uploadPath);
		
	}
}
