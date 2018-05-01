package com.hu.dao;

import java.util.List;

import com.hu.model.Customer;

public interface CustomerDAO {

	List<Customer> findAllcustomer();

	int deletecustomer(String string);

	int insertcustomer(Customer customer);

	int updatecustomer(Customer customer);


}
