package com.hu.blservice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.SupplierBL;
import com.hu.dao.SupplierDAO;
import com.hu.model.Supplier;

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

	@Override
	public List<Supplier> findAllsupplier() {
		// TODO Auto-generated method stub
		return supplierDAO.findAllsupplier();
	}

	@Override
	public int deletesupplier(String[] supplierID) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<supplierID.length;i++){
			n=this.supplierDAO.deletesupplier(supplierID[i]);
		}
		return n;
	}

	@Override
	public int insertsupplier(List<Supplier> supplier) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<supplier.size();i++){
			n=this.supplierDAO.insertsupplier(supplier.get(i));
		}
		return n;
	}

	@Override
	public int updatesupplier(List<Supplier> supplier) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<supplier.size();i++){
			n=this.supplierDAO.updatesupplier(supplier.get(i));
		}
		return n;
	}

	@Override
	public int updatesupplierdate(Supplier supplier,Date date) {
		// TODO Auto-generated method stub
		return this.supplierDAO.updatesupplierdate(supplier,date);
	}

	}
