package com.cjl.onrefectory.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
public class V {
	/**
	 * ��֤�ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 * @throws InvalidParamException 
	 */
	public static void isEmpty(String... strs) {
		for(int i =0; i < strs.length; i++) {
			String str = strs[i];
			if(str == null || str.length() == 0) {
//				throw new InvalidParamException(str + "����Ϊ��");
			}
		}		
	}
	
	/**
	 * �Զ���������
	 * @param req
	 * @param clz
	 * @param keys
	 * @return
	 */
	public static <T> T entity(HttpServletRequest req,Class clz,String[] keys) {
		try {
			//��������
			T instance = (T) clz.newInstance();
			for(String key : keys) {
				//��ȡָ������
				String paramValue = req.getParameter(key);
				String param = NameUtil.toCamel(key, true);
				//����set��������
				String setMethod = "set" + param;
			    //
				String paramName = NameUtil.toCamel(key, false);
				Field field = clz.getDeclaredField(paramName);
				Class paramType = field.getType();
				//
				String typeName = paramType.getTypeName();
				Object value = null;
				//
				if(typeName.equals("java.lang.Integer") || typeName.equals("int")) {
					value = Integer.parseInt(paramValue);
				}else if(typeName.equals("java.lang.Double") || typeName.equals("double")) {
					value = Double.parseDouble(paramValue);
				}else if(typeName.equals("java.lang.Long") || typeName.equals("long")) {
					value = Long.parseLong(paramValue);
				}else {
					value = paramValue;
				}
				//ֵ
				Method method = clz.getMethod(setMethod, paramType);
				method.invoke(instance, value);
			}
			
			return instance;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 从请求（req）中获取参数
	 * @param req
	 * @param key
	 * @param def 
	 * @return
	 */
	public static String getData(HttpServletRequest req,String key, String def) {
		String value = req.getParameter(key);
		if(value == null) {
			return def;
		}
		return value;
	}
}
