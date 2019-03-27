package com.cjl.onrefectory.web;

public class Result implements BaseResult{
	//转发的地址
	private String dispatchUrl;
	public String getDispatchUrl() {
		return dispatchUrl;
	}
	public Result setDispatchUrl(String dispatchUrl) {
		this.dispatchUrl = dispatchUrl;
		return this;
	}
	public static Result build() {
		return new Result();
	}
	@Override
	public String toString() {
		return "Result [dispatchUrl=" + dispatchUrl + "]";
	}
	 
}
