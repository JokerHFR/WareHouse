package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.SupplierBL;
import com.hu.dao.SupplierDAO;

public class SupplierBLimpl implements SupplierBL{
    @Autowired()
    @Qualifier("supplierDAOimpl")
    private  SupplierDAO supplierDAO;

	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}
}
