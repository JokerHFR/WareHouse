package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.BuyerBL;
import com.hu.dao.BuyerDAO;
import com.hu.model.Buyer;

public class BuyerBLimpl implements BuyerBL {
    @Autowired()
    @Qualifier("buyerDAOimpl")
    private BuyerDAO buyerDAO;
    
    public BuyerDAO getUserDAO() {
        return buyerDAO;
    }

    public void setUserDAO(BuyerDAO userDAO) {
        this.buyerDAO = userDAO;
    }

    @Override
    public Buyer findLogin(String uname, String uword) throws Exception { 
        return  this.buyerDAO.login(uname, uword);
    }

	@Override
	public int insertRegister(String uname, String uword) throws Exception {
		// TODO Auto-generated method stub
		 return  this.buyerDAO.register(uname, uword);
	}

	@Override
	public int updateinformation(long id, String uname, String sex,
			String date, String tele, String email) throws Exception {
		// TODO Auto-generated method stub
		return this.buyerDAO.information(id, uname, sex,
				date, tele, email);
	}

}


