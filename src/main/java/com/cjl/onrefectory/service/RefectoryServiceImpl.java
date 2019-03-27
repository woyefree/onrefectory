package com.cjl.onrefectory.service;

import java.util.List;

import com.cjl.onrefectory.ex.InvalidParamException;
import com.cjl.onrefectory.mapper.RefectoryMapper;
import com.cjl.onrefectory.po.Refectory;
import com.cjl.onrefectory.util.D;
import com.cjl.onrefectory.web.PageData;

public class RefectoryServiceImpl implements RefectoryService{
	private RefectoryMapper refectoryMapper;
	public RefectoryServiceImpl() {
		refectoryMapper = D.open().getMapper(RefectoryMapper.class);
	}
	/**
	 * 添加餐厅
	 */
	public void save(Refectory refectory) {
		refectoryMapper.insert(refectory);
	}
	/**
	 * 验证电话号(餐厅)是否存在
	 */
	public boolean validTel(String tel) {
		Refectory refectory = refectoryMapper.getRefectoryByTel(tel);
		if(refectory != null) {
			return true;
		}
		return false;
	}
	public PageData<Refectory> list(int curPage, int pageSize, String Keyword) {
		//1.统计满足查询条件的记录数量
		int totalRecord = refectoryMapper.refectoryListCount(Keyword);
		//2.按条件返回相关记录
		int begin = (curPage - 1) * pageSize;
		//3.构建分页数据对象并返回 
		List<Refectory> data = refectoryMapper.refectoryList(begin, pageSize, Keyword);
		PageData<Refectory> pageData = new PageData<Refectory>(pageSize, curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	/**
	 * 通过id查询餐厅
	 */
	public Refectory getRefectoryById(int id) throws InvalidParamException {
		return refectoryMapper.getRefectoryById(id);
	}
	/**
	 * 通过id更新餐厅信息
	 */
	public void update(Refectory refectory) {
		refectoryMapper.updateById(refectory);
	}
	/**
	 * 根据id删除指定的餐厅
	 * @param id
	 */
	public void delete(int id) {
		refectoryMapper.deleteById(id);
	}
	
}
