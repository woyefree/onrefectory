package com.cjl.onrefectory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjl.onrefectory.po.Refectory;

public interface RefectoryMapper {
	//插入餐厅信息
	public void insert(Refectory refectory);
	
	//根据电话号查询餐厅
	public Refectory getRefectoryByTel(String tel);
	
	/**
	 * 返回满足查询条件的记录总数
	 * @param keyword
	 * @return
	 */
	public int refectoryListCount(@Param("keyword")String keyword); 
	/**
	 * 按照条件返回指定数量的数据
	 * @param begin
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public List<Refectory> refectoryList(@Param("begin")int begin,
				@Param("pageSize")int pageSize,@Param("keyword")String keyword); 
	/**
	 * 通过id查询餐厅
	 * @param id
	 * @return
	 */
	public Refectory getRefectoryById(int id);
	/**
	 * 通过id更新餐厅信息
	 * @param refectory
	 */
	public void updateById(Refectory refectory);
	/**
	 * 根据id删除指定餐厅
	 * @param id
	 */
	public void deleteById(int id);
}
