package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.PurchasemasterBL;
import com.hu.dao.PurchasemasterDAO;


public class PurchasemasterBLimpl implements PurchasemasterBL{
	 @Autowired()
	    @Qualifier("purchasemasterDAOimpl")
	    private  PurchasemasterDAO  purchasemasterDAO;

	public PurchasemasterDAO getPurchasemasterDAO() {
		return purchasemasterDAO;
	}

	public void setPurchasemasterDAO(PurchasemasterDAO purchasemasterDAO) {
		this.purchasemasterDAO = purchasemasterDAO;
	}
}
