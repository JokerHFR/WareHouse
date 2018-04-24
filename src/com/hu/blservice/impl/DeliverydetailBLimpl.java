package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.DeliverydetailBL;
import com.hu.dao.DeliverydetailDAO;


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
}
