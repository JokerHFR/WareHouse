package com.hu.dao;

import java.util.Date;
import java.util.List;

import com.hu.model.Product;

public interface ProductDAO {
     public List<Product> findAllproduct();
     public List<Product> findproduct(String supplierid); 
     public int deleteproduct(String ProductID); 
     public int insertproduct(Product product);  
     public int updateproduct(Product product);
     public int productupdatequa(Product product,Date date);
	 public int productupdatequa(Product product,int i);
	 public int productupdatepur(Product product,Date date);
}
