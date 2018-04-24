package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.SalesmanBL;
import com.hu.dao.SalesmanDAO;


public class SalesmanBLimpl implements SalesmanBL{
	 @Autowired()
	    @Qualifier("salesmanDAOimpl")
	    private SalesmanDAO salesmanDAO;

	public SalesmanDAO getSalesmanDAO() {
		return salesmanDAO;
	}

	public void setSalesmanDAO(SalesmanDAO salesmanDAO) {
		this.salesmanDAO = salesmanDAO;
	}
}
