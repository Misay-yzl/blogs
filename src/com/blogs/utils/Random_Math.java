package com.blogs.utils;

public class Random_Math {
	//��ȡ6λ����֤��
	public static String getMath(){
		String math="";
		for (int i = 0; i < 6; i++) {
			int random=(int)(Math.random()*10);
			math+=random;
		}
		return math; 
	}
}
