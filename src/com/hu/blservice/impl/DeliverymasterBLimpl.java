package com.hu.blservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.DeliverymasterBL;
import com.hu.dao.DeliverymasterDAO;
import com.hu.model.Deliverymaster;


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

	@Override
	public List<Deliverymaster> findAlldeliverymaster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletedeliverymaster(String[] deliverymasterID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertdeliverymaster(List<Deliverymaster> deliverymaster) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatedeliverymaster(List<Deliverymaster> deliverymaster) {
		// TODO Auto-generated method stub
		return 0;
	}
}
