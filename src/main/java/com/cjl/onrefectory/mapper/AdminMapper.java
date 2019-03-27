package com.cjl.onrefectory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjl.onrefectory.po.Admin;

public interface AdminMapper {
	/**
	 * 插入教师信息
	 * @param teacher
	 */
	public void insert(Admin admin);
	/**
	 * 根据电话号码查询admin
	 * @param tel
	 * @return
	 */
	public Admin getAdminByTel(String tel);
	/**
	 * 返回满足查询条件的记录总数
	 * @param keyword
	 * @return
	 */
	public int adminListCount(@Param("keyword")String keyword); 
	/**
	 * 按照条件返回指定数量的数据
	 * @param begin
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public List<Admin> adminList(@Param("begin")int begin,
				@Param("pageSize")int pageSize,@Param("keyword")String keyword); 
	/**
	 * 根据id查询admin
	 * @param id
	 * @return
	 */
	public Admin getAdminById(int id);
	/**
	 * 根据id更新admin
	 * @param admin
	 */
	public void updateById(Admin admin);
	/**
	 * 根据id删除admin
	 * @param admin
	 */
	public void deleteById(int id);
	/**
	 * 获取所有admin
	 * @return
	 */
	public List<Admin> list();
}
