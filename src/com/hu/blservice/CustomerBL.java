package com.hu.blservice;

import java.util.Date;
import java.util.List;

import com.hu.model.Customer;

public interface CustomerBL {
	/**
	 * 返回所有客户信息
	 * @return
	 */
     public List<Customer> findAllcustomer();
     /**
      * 批量删除客户
      * @param customerID 客户编号的数组
      * @return
      */
     public int deletecustomer(String[] customerID);
     /**
      * 添加客户信息
      * @param customer 客户信息
      * @return
      */
     public int insertcustomer(List<Customer> customer);
     /**
      * 修改客户信息
      * @param customer 客户信息
      * @return
      */
     public int updatecustomer(List<Customer> customer);
     /**
      * 修改客户进货日期
      * @param customer 客户信息
      * @return
      */
     public int updatecustomerdate(Customer customer,Date date);
}
