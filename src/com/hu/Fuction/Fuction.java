package com.hu.Fuction;

public class Fuction {
	/**
	 * �����ַ����ȹ̶�
	 * @param len  �趨���� �����ÿո�
	 * @param s  ���ع̶��õ�����
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
