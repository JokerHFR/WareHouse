package com.hu.blservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.SalesmanBL;
import com.hu.dao.SalesmanDAO;
import com.hu.model.Salesman;


public class SalesmanBLimpl implements SalesmanBL{
	 @Autowired()
	    @Qualifier("salesmanDAOimpl")
	    private SalesmanDAO salesmanDAO;

	public SalesmanDAO getSalesmanDAO() {
		return salesmanDAO;
	}

	public void setSalesmanDAO(SalesmanDAO salesmanDAO) {
		this.salesmanDAO = salesmanDAO;
	}

	@Override
	public List<Salesman> findAllsalesman() {
		// TODO Auto-generated method stub
		return this.salesmanDAO.findAllsalesman();
	}

	@Override
	public int deletesalesman(String salesmanID[]) {
		// TODO Auto-generated method stub
		int n=0;
		for(int a=0;a<salesmanID.length;a++){
			n=this.salesmanDAO.deletesalesman(salesmanID[a]);
		}
		return n;
	}

	@Override
	public int insertsalesman(List<Salesman> salesman) {
		int n=0;
		// TODO Auto-generated method stub
		for(int i=0;i<salesman.size();i++){
		n=this.salesmanDAO.insertsalesman(salesman.get(i));
		}
		return n;
	}

	@Override
	public int updatesalesman(List<Salesman> salesman) {
		// TODO Auto-generated method stub
		int a=0;
		for(int i=0;i<salesman.size();i++){
		a=this.salesmanDAO.updatesalesman(salesman.get(i));
		}
		return a;
	}
}
