package com.hu.blservice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.CustomerBL;
import com.hu.dao.CustomerDAO;
import com.hu.model.Customer;


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

	@Override
	public List<Customer> findAllcustomer() {
		// TODO Auto-generated method stub
		return this.customerDAO.findAllcustomer();
	}

	@Override
	public int deletecustomer(String[] customerID) {
		// TODO Auto-generated method stub
		int n=0;
		for(int a=0;a<customerID.length;a++){
			n=this.customerDAO.deletecustomer(customerID[a]);
		}
		return n;
	}

	@Override
	public int insertcustomer(List<Customer> customer) {
		// TODO Auto-generated method stub
		int n=0;
		// TODO Auto-generated method stub
		for(int i=0;i<customer.size();i++){
		n=this.customerDAO.insertcustomer(customer.get(i));
		}
		return n;
	}

	@Override
	public int updatecustomer(List<Customer> customer) {
		// TODO Auto-generated method stub
		int a=0;
		for(int i=0;i<customer.size();i++){
		a=this.customerDAO.updatecustomer(customer.get(i));
		}
		return a;
	}

	@Override
	public int updatecustomerdate(Customer customer, Date date) {
		// TODO Auto-generated method stub
		return this.customerDAO.updatecustomerdate(customer, date);
	}
}
