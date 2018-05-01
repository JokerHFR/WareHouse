package com.hu.dao;

import java.util.List;

import com.hu.model.Product;

public interface ProductDAO {
     public List<Product> findAllproduct();
     public List<Product> findproduct(String supplierid); 
     public int deleteproduct(String ProductID); 
     public int insertproduct(Product product);  
     public int updateproduct(Product product);
}
