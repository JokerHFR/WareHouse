package com.hu.Fuction;

public class Fuction {
	/**
	 * 数据字符长度固定
	 * @param len  设定长度 多余用空格补
	 * @param s  返回固定好的数据
	 * @return
	 */
	public static String Str(int len,String s){
    	StringBuffer sr=new StringBuffer();
    	for(int i=0;i<len;i++){
    		sr.append(" ");
    	}
    	sr.append(s);
    	for(int i=0;i<len-s.length();i++){
    		sr.append(" ");
    	}
    	
    	return sr.toString();
    }
}
