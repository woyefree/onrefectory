package com.cjl.onrefectory.service;



import java.util.List;

import com.cjl.onrefectory.mapper.AdminMapper;
import com.cjl.onrefectory.po.Admin;
import com.cjl.onrefectory.util.D;
import com.cjl.onrefectory.web.PageData;
import com.cjl.onrefectory.ex.InvalidParamException;
import com.cjl.onrefectory.util.GlobalInfo;

public class AdminServiceImpl implements AdminService {
	private AdminMapper adminMapper;
	public AdminServiceImpl() {
		adminMapper = D.open().getMapper(AdminMapper.class);
	}
	/**
	 * 添加管理员
	 * @param admin
	 */
	public void save(Admin admin) {
		adminMapper.insert(admin);
	}
	/**
	 * 验证电话号码是否存在
	 * @param tel
	 * @return
	 */
	public boolean validTel(String tel) {
		Admin admin = adminMapper.getAdminByTel(tel);
		if(admin != null) {
			return true;
		}
		return false;
	}
	/**
	 * 按条件进行分页查找admin
	 */
	public PageData<Admin> list(int curPage, int pageSize, String Keyword) {
		//接下来的任务：
		//1.统计满足查询条件的记录数量
		int totalRecord = adminMapper.adminListCount(Keyword);
		//2.按条件返回相关记录
		int begin = (curPage - 1) * pageSize;
		//3.构建分页数据对象并返回 
		List<Admin> data = adminMapper.adminList(begin, pageSize, Keyword);
		PageData<Admin> pageData = new PageData<Admin>(pageSize, curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	/**
	 * 管理员登陆
	 * @throws InvalidParamException 
	 */
	public Admin login(Admin admin) throws InvalidParamException{
		Admin existAdmin = adminMapper.getAdminByTel(admin.getTel()); 
		if(existAdmin == null) {
			throw new InvalidParamException(GlobalInfo.UESER_INFO_ERROR_CODE,GlobalInfo.UESER_INFO_ERROR_MSG);

		}
		if(!existAdmin.getPwd().equals(admin.getPwd())) {
			throw new InvalidParamException(GlobalInfo.UESER_INFO_ERROR_CODE,GlobalInfo.UESER_INFO_ERROR_MSG);
		}
		return existAdmin;   //增加返回类型，便于保存到session中
	}
	/**
	 * 通过id查找用户
	 */
	public Admin getAdminById(int id) throws InvalidParamException {
		
		return adminMapper.getAdminById(id);
	}
	/**
	 * 通过id修改admin信息
	 */
	public void update(Admin admin) {
		adminMapper.updateById(admin);
	}
	/**
	 * 删除admin
	 */
	public void delete(int id) {
		adminMapper.deleteById(id);
	}
	/**
	 * 获取所有admin
	 */
	public List<Admin> getAllAdmin(){
		List<Admin> admins = adminMapper.list();
		return admins;
	}
	
}
