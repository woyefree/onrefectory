package com.cjl.onrefectory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.cjl.onrefectory.ex.InvalidParamException;
import com.cjl.onrefectory.po.Admin;
import com.cjl.onrefectory.po.Refectory;
import com.cjl.onrefectory.service.AdminService;
import com.cjl.onrefectory.service.AdminServiceImpl;
import com.cjl.onrefectory.service.RefectoryService;
import com.cjl.onrefectory.service.RefectoryServiceImpl;
import com.cjl.onrefectory.util.UrlList;
import com.cjl.onrefectory.util.V;
import com.cjl.onrefectory.web.ApiResult;
import com.cjl.onrefectory.web.PageData;
import com.cjl.onrefectory.web.Result;

public class RefectoryController {
	private RefectoryService refectoryService;
	private AdminService adminService;
	private static Logger log = Logger.getLogger(AdminController.class);
	public RefectoryController() {
		refectoryService = new RefectoryServiceImpl();
		adminService = new AdminServiceImpl();
	}
	/**
	 * 添加餐厅
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doAdd(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"desc","tel"};
		V.isEmpty(params);
		Refectory refectory = V.entity(req, Refectory.class, params);
		//接受页面传过来的admin_id
		String admin_id = req.getParameter("admin_id");
		Long id = Long.parseLong(admin_id);
		
		Admin admin = new Admin();
		admin.setId(id);
		refectory.setAdmin(admin);
		
		refectoryService.save(refectory);
		req.setAttribute("info", "添加成功");
		//转发的地址
		Result rs = Result.build().setDispatchUrl(UrlList.refectoryAdd);
		return rs;
	}
	/**
	 * 将admin信息转发到refectory_add页面
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result add(HttpServletRequest req,HttpServletResponse resp) {
		List<Admin> list = adminService.getAllAdmin();
		req.setAttribute("admins", list);
		Result rs = Result.build().setDispatchUrl(UrlList.addRefectory);
		return rs;
	}
	/**
	 * 验证电话号是否存在
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult validTel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel"};
		V.isEmpty(params);
		String tel = req.getParameter("tel");
		Boolean hasExistTel = refectoryService.validTel(tel);
		//返回客户端的结果
		ApiResult ars = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExistTel);
		ars.setData(info);
		return ars;
	}
	/**
	 * 展示餐厅列表
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
		PageData<Refectory> refectorys = refectoryService.list(curPage, pageSize, keyword);
		req.setAttribute("refectorys", refectorys);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + refectorys);
		return Result.build().setDispatchUrl(UrlList.refectoryList);
		
	}
	/**
	 * 餐厅修改,主要展示要修改的信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public Result doEdit(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"id"};
		V.isEmpty(params);
		int id = Integer.parseInt(req.getParameter("id"));
		Refectory refectory = refectoryService.getRefectoryById(id);
		req.setAttribute("refectory",refectory);
		return Result.build().setDispatchUrl(UrlList.refectoryEdit);
	}
	/**
	 * 将页面转发到edit
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		List<Admin> list = adminService.getAllAdmin();
		req.setAttribute("admins", list);
		Result rs = Result.build().setDispatchUrl(UrlList.editRefectory);
		return rs;
	}
	/**
	 * 更新餐厅信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public ApiResult update(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"id","tel","desc"};
		V.isEmpty(params);
		Refectory refectory = V.entity(req, Refectory.class, params);
		
		
		Long admin_id = Long.parseLong(req.getParameter("admin_id"));
		
		int id = Integer.parseInt(req.getParameter("id"));
//		refectory = refectoryService.getRefectoryById(id);
		Admin admin = new Admin();
		admin.setId(admin_id);
		refectory.setAdmin(admin);
		//调用service方法
		refectoryService.update(refectory);
		return ApiResult.build();
	}
	/**
	 * 删除餐厅信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public ApiResult delete(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"id"};
		V.isEmpty(params);
		int id = Integer.parseInt(req.getParameter("id"));
		//调用service方法
		refectoryService.delete(id);
		return ApiResult.build();
	}
}
