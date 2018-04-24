package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.CustomerBL;
import com.hu.dao.CustomerDAO;


public class CustomerBLimpl implements CustomerBL{
	@Autowired()
    @Qualifier("customerDAOimpl")
    private CustomerDAO  customerDAO;

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
}
