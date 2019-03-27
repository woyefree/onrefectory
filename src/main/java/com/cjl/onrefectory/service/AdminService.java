package com.cjl.onrefectory.service;

import com.cjl.onrefectory.po.Admin;
import com.cjl.onrefectory.web.PageData;

import java.util.List;

import com.cjl.onrefectory.ex.BaseException;
import com.cjl.onrefectory.ex.InvalidParamException;

public interface AdminService {
	
	/**
	 * 添加管理员
	 * @param admin
	 */
	public void save(Admin admin);
	/**
	 * 验证电话号码是否存在
	 * @param tel
	 * @return
	 */
	public boolean validTel(String tel);
	/**
	 * 分页查找admin信息
	 * @param curPage
	 * @param pageSize
	 * @param Keyword
	 * @return
	 */
	public PageData<Admin> list(int curPage,int pageSize,String Keyword);
	/**
	 *用户登录
	 * @throws com.cjl.onrefectory.ex.InvalidParamException 
	 * @throws BaseException 
	 */
	public Admin login(Admin admin) throws InvalidParamException;
	/**
	 * 获取用户id
	 * @param id
	 * @return
	 */
	public Admin getAdminById(int id) throws InvalidParamException;
	/**
	 * 更新admin信息
	 * @param admin
	 */
	public void update(Admin admin);
	/**
	 * 删除指定的admin
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 获取所有admin
	 */
	public List<Admin> getAllAdmin();
}
