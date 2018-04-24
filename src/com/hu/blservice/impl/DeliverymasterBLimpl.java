package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.DeliverymasterBL;
import com.hu.dao.DeliverymasterDAO;


public class DeliverymasterBLimpl implements DeliverymasterBL{
	@Autowired()
    @Qualifier("deliverymasterDAOimpl")
    private  DeliverymasterDAO   deliverymasterDAO;

	public DeliverymasterDAO getDeliverymasterDAO() {
		return deliverymasterDAO;
	}

	public void setDeliverymasterDAO(DeliverymasterDAO deliverymasterDAO) {
		this.deliverymasterDAO = deliverymasterDAO;
	}
}
