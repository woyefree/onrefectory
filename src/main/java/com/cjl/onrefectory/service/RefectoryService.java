package com.cjl.onrefectory.service;

import com.cjl.onrefectory.ex.InvalidParamException;
import com.cjl.onrefectory.po.Refectory;
import com.cjl.onrefectory.web.PageData;

public interface RefectoryService {
	/**
	 * 添加餐馆
	 * @param refectory
	 */
	public void save(Refectory refectory);
	
	/**
	 * 验证电话号码是否存在
	 * @param tel
	 * @return
	 */
	public boolean validTel(String tel);
	/**
	 * 分页显示餐厅信息
	 * @param curPage
	 * @param pageSize
	 * @param Keyword
	 * @return
	 */
	public PageData<Refectory> list(int curPage,int pageSize,String Keyword); 
	/**
	 * 根据id获取餐厅
	 * @param id
	 * @return
	 */
	public Refectory getRefectoryById(int id) throws InvalidParamException;
	/**
	 * 更新餐厅信息
	 * @param refectory
	 */
	public void update(Refectory refectory);
	/**
	 * 根据id删除指定的餐厅
	 * @param id
	 */
	public void delete(int id);
}
