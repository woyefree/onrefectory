package com.cjl.onrefectory.ex;

public class BaseException extends Exception{
	private int code;
	public BaseException() {
		
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public BaseException(String msg) {
		super(msg);
	}
	public BaseException(int code,String msg) {
		super(msg);
		this.code = code;
	}
}
