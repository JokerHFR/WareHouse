package com.hu.dao;

import com.hu.model.Buyer;

public interface BuyerDAO {
    public Buyer login(String uname,String uword) throws Exception;
    public int register(String uname,String uword) throws Exception;
    public int information(long id, String uname, String sex,
			String date, String tele, String email) throws Exception;
}


