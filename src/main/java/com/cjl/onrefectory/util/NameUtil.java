package com.cjl.onrefectory.util;

import java.util.Arrays;
//String ����ΪʲôЧ�ʵ�
public class NameUtil {
	/**
	 * ת��Ϊ�շ�ṹ
	 * @param varName
	 * @return
	 */
	public static String toCamel(String varName,boolean isClass) {
		String[] names = varName.split("_");
		
		StringBuilder finalName = new StringBuilder();
		int i = 0;
		if(isClass == false) {
			if(names.length == 1) {
				return varName;
			}
			i = 1;
			finalName.append(names[0]);
		}
		
		for(; i < names.length; i++) {
			String temp = names[i];
			char ch = temp.charAt(0);
			ch = Character.toUpperCase(ch);
			temp = ch + temp.substring(1);
			
			finalName.append(temp);
		}
		
		return finalName.toString();
	}
	
	public static void main(String[] args) {
		String name = "user_test_tes1"; //userTestTest1
		System.out.println(toCamel(name,false));
	}
}
