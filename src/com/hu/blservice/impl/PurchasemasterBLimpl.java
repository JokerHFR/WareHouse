package com.hu.blservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.PurchasemasterBL;
import com.hu.dao.PurchasemasterDAO;
import com.hu.model.Purchasemaster;


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

	@Override
	public List<Purchasemaster> findAllpurchasemaster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletepurchasemaster(String[] purchasemasterID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertpurchasemaster(List<Purchasemaster> purchasemaster) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatepurchasemaster(List<Purchasemaster> purchasemaster) {
		// TODO Auto-generated method stub
		return 0;
	}
}
