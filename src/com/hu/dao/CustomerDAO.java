package com.hu.dao;

import java.util.Date;
import java.util.List;

import com.hu.model.Customer;

public interface CustomerDAO {

	public List<Customer> findAllcustomer();

	public int deletecustomer(String string);

	public int insertcustomer(Customer customer);

	public int updatecustomer(Customer customer);

    public int updatecustomerdate(Customer customer,Date date);
}
