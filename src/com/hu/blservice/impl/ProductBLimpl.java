package com.hu.blservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.ProductBL;
import com.hu.dao.ProductDAO;


public class ProductBLimpl implements ProductBL{
	@Autowired()
    @Qualifier("productDAOimpl")
    private ProductDAO  productDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
}
