package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.SupcontactBL;
import com.hu.dao.SupcontactDAO;


public class SupcontactBLimpl implements SupcontactBL{
	  @Autowired()
	    @Qualifier("supcontactDAOimpl")
	    private SupcontactDAO supcontactDAO;

	public SupcontactDAO getSupcontactDAO() {
		return supcontactDAO;
	}

	public void setSupcontactDAO(SupcontactDAO supcontactDAO) {
		this.supcontactDAO = supcontactDAO;
	}
}
