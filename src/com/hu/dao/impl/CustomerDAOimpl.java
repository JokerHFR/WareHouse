package com.hu.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.CustomerDAO;
import com.hu.model.Customer;

public class CustomerDAOimpl implements CustomerDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public List<Customer> findAllcustomer() {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("customer.customerfindAll");
		}

		@Override
		public int deletecustomer(String i) {
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("customerid", i);
			return this.sqlSessionTemplate.delete("customer.customerdelete",map);
		}

		@Override
		public int insertcustomer(Customer customer) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("CustomerID", customer.getCustomerID());
	        map.put("CustomerSimpleName", customer.getCustomerSimpleName());
	        map.put("CustomerName", customer.getCustomerName());
	        map.put("CustomerOwner", customer.getCustomerOwner());
	        map.put("CustomerTele", customer.getCustomerTele());
	        map.put("CustomerMob", customer.getCustomerMob());
	        map.put("CustomerFax", customer.getCustomerFax());
	        map.put("CustomerAddress", customer.getCustomerAddress());
	        map.put("DeliveryAddress", customer.getDeliveryAddress());
	        map.put("InvoiceAddress", customer.getInvoiceAddress());
	        map.put("LastDeliveryDate", customer.getLastDeliveryDate());
	        return this.sqlSessionTemplate.insert("customer.customerinsert",map);
		}

		@Override
		public int updatecustomer(Customer customer) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("CustomerID", customer.getCustomerID());
	        map.put("CustomerSimpleName", customer.getCustomerSimpleName());
	        map.put("CustomerName", customer.getCustomerName());
	        map.put("CustomerOwner", customer.getCustomerOwner());
	        map.put("CustomerTele", customer.getCustomerTele());
	        map.put("CustomerMob", customer.getCustomerMob());
	        map.put("CustomerFax", customer.getCustomerFax());
	        map.put("CustomerAddress", customer.getCustomerAddress());
	        map.put("DeliveryAddress", customer.getDeliveryAddress());
	        map.put("InvoiceAddress", customer.getInvoiceAddress());
	        map.put("LastDeliveryDate", customer.getLastDeliveryDate());
			return this.sqlSessionTemplate.update("customer.customerupdate",map);
		}

		@Override
		public int updatecustomerdate(Customer customer, Date date) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("CustomerID", customer.getCustomerID());
	        map.put("LastDeliveryDate", date);
			return this.sqlSessionTemplate.update("customer.customerupdatedate",map);
		}

}
