package com.hu.blservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.PurchasedetailBL;
import com.hu.dao.PurchasedetailDAO;
import com.hu.model.Purchasedetail;



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

	@Override
	public int insertpurchasedetail(List<Purchasedetail> purchasedetail) {
		// TODO Auto-generated method stub
		return 0;
	}
}
