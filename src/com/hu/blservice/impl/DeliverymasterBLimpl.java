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
		return this.deliverymasterDAO.findAlldeliverymaster();
	}

	@Override
	public int deletedeliverymaster(String[] deliverymasterID) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<deliverymasterID.length;i++){
		n=this.deliverymasterDAO.deletedeliverymaster(deliverymasterID[i]);
		}
		return n;
	}

	@Override
	public int insertdeliverymaster(Deliverymaster deliverymaster) {
		// TODO Auto-generated method stub
		return this.deliverymasterDAO.insertdeliverymaster(deliverymaster);
	}

	@Override
	public int updatedeliverymaster(List<Deliverymaster> deliverymaster) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<deliverymaster.size();i++){
		n=this.deliverymasterDAO.updatedeliverymaster(deliverymaster.get(i));
		}
		return n;
	}
}
