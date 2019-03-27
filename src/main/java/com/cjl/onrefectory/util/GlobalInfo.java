package com.cjl.onrefectory.util;

public class GlobalInfo {
	public static final int SUCCESS_CODE = 200;
	public static final String SUCCESS_MSG = "succcess";
	
	public static final int INVALID_PARAM_CODE = 1000;
	public static final String INVALID_PARAM_MSG = "请求参数异常";
	
	public static final int INVALID_IMGTYPE_CODE = 1001;
	public static final String INVALID_FILE_MSG = "文件类型不合法";
	/**
	 * 用户模块
	 */
	public static final int UESER_INFO_ERROR_CODE = 1001;
	public static final String UESER_INFO_ERROR_MSG = "用户名或密码不正确";
	//用户没有登录
	public static final int UESER_NO_LOGIN_CODE = 2001;
	public static final String UESER_NO_LOGIN_MSG = "未登录";
	
	public static final int NO_PRIVILEDGE_CODE = 2002;
	public static final String NO_PRIVILEDGE_MSG = "没有操作权限";
}
