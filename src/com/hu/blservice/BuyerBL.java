package com.hu.blservice;

import com.hu.model.Buyer;


public interface BuyerBL {
    public Buyer findLogin(String uname,String uword) throws Exception;
    public int insertRegister(String uname,String uword) throws Exception;
	public int updateinformation(long id, String uname, String sex,
			String date, String tele, String email)throws Exception;
}


