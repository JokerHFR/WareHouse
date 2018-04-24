package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.PurchasedetailBL;
import com.hu.dao.PurchasedetailDAO;



public class PurchasedetailBLimpl implements PurchasedetailBL{
	 @Autowired()
	    @Qualifier("purchasedetailDAOimpl")
	    private  PurchasedetailDAO  purchasedetailDAO;

	public PurchasedetailDAO getPurchasedetailDAO() {
		return purchasedetailDAO;
	}

	public void setPurchasedetailDAO(PurchasedetailDAO purchasedetailDAO) {
		this.purchasedetailDAO = purchasedetailDAO;
	}
}
