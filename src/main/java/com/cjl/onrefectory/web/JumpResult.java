package com.cjl.onrefectory.web;

public class JumpResult implements BaseResult{
	private String jumpUrl;

	public String getJumpUrl() {
		return jumpUrl;
	}

	public JumpResult setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
		return this;
	}
	public static JumpResult build() {
		return new JumpResult();
	}
	@Override
	public String toString() {
		return "JumpResult [jumpUrl=" + jumpUrl + "]";
	}
	
	
}

