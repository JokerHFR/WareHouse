package com.hu.blservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.DeliverydetailBL;
import com.hu.dao.DeliverydetailDAO;
import com.hu.model.Deliverydetail;


public class DeliverydetailBLimpl implements DeliverydetailBL{
	@Autowired()
    @Qualifier("deliverydetailDAOimpl")
    private DeliverydetailDAO  deliverydetailDAO;

	public DeliverydetailDAO getDeliverydetailDAO() {
		return deliverydetailDAO;
	}

	public void setDeliverydetailDAO(DeliverydetailDAO deliverydetailDAO) {
		this.deliverydetailDAO = deliverydetailDAO;
	}

	@Override
	public int insertdeliverydetail(List<Deliverydetail> deliverydetail) {
		// TODO Auto-generated method stub
		return 0;
	}
}
