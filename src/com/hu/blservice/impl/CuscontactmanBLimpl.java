package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.CuscontactmanBL;
import com.hu.dao.CuscontactmanDAO;


public class CuscontactmanBLimpl implements CuscontactmanBL{
	@Autowired()
    @Qualifier("cuscontactmanDAOimpl")
    private CuscontactmanDAO  cuscontactmanDAO;

	public CuscontactmanDAO getCuscontactmanDAO() {
		return cuscontactmanDAO;
	}

	public void setCuscontactmanDAO(CuscontactmanDAO cuscontactmanDAO) {
		this.cuscontactmanDAO = cuscontactmanDAO;
	}
}
