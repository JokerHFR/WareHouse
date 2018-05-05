package com.hu.blservice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.ProductBL;
import com.hu.dao.ProductDAO;
import com.hu.model.Product;


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

	@Override
	public List<Product> findAllproduct() {
		// TODO Auto-generated method stub
		return this.productDAO.findAllproduct();
	}

	@Override
	public List<Product> findproduct(String supplierid) {
		// TODO Auto-generated method stub
		return this.productDAO.findproduct(supplierid);
	}

	@Override
	public int deleteproduct(String[] ProductID) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<ProductID.length;i++){
			n=this.productDAO.deleteproduct(ProductID[i]);
		}
		return n;
	}

	@Override
	public int insertproduct(List<Product> Product) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<Product.size();i++){
			n=this.productDAO.insertproduct(Product.get(i));
		}
		return n;
	}

	@Override
	public int updateproduct(List<Product> Product) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<Product.size();i++){
			n=this.productDAO.updateproduct(Product.get(i));
		}
		return n;
	}

	@Override
	public int productupdatequa(List<Product> product,Date date) {
		// TODO Auto-generated method stub
		int n=0;
		for(int i=0;i<product.size();i++){
			n=this.productDAO.productupdatequa(product.get(i),date);
		}
		return n;
	}
}
