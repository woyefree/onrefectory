package com.cjl.onrefectory.web;

import java.util.List;

public class PageData<T> {
	private int curPage;     //当前页码
	private int totalPage;   //总页数
	private int totalRecord; //数据总数
	private int pageSize;    //每页数据数量
	private List<T> data;    //返回的数据
	@Override
	public String toString() {
		return "PageData [curPage=" + curPage + ", totalPage=" + totalPage + ", totalRecord=" + totalRecord
				+ ", pageSize=" + pageSize + ", data=" + data + "]";
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public PageData(int pageSize,int curPage) {
		this.pageSize = pageSize;
		this.curPage = curPage;
	}
	/**
	 * 求总页数
	 * @return
	 */
	public int getTotalPage() {
		totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize 
				: (totalRecord / pageSize) + 1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
