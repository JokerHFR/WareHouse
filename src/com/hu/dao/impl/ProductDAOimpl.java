package com.hu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.ProductDAO;
import com.hu.model.Product;

public class ProductDAOimpl implements ProductDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public List<Product> findAllproduct() {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("product.productfindAll");
		}

		@Override
		public List<Product> findproduct(String supplierid) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("supplier", supplierid);
		    return this.sqlSessionTemplate.selectList("product.productfindbysupplierid",map);
		}

		@Override
		public int deleteproduct(String ProductID) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("productid", ProductID);
			return this.sqlSessionTemplate.delete("product.productdelete", map);
		}

		@Override
		public int insertproduct(Product product) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("productid", product.getProductID());
	        map.put("productname", product.getProductName());
	        map.put("productunit", product.getProductUnit());
	        map.put("safestock", product.getSafeStock());
	        map.put("lastpurdate", product.getLastPurDate());
	        map.put("lastdeldate", product.getLastDelDate());
	        map.put("quantity", product.getQuantity());
	        map.put("suggestbuyprice", product.getSuggestBuyPrice());
	        map.put("suggestsaleprice", product.getSuggestSalePrice());
	        map.put("supplierid", product.getSupplier().getSupplierID());
			return this.sqlSessionTemplate.insert("product.productinsert", map);
		}

		@Override
		public int updateproduct(Product product) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("productid", product.getProductID());
	        map.put("productname", product.getProductName());
	        map.put("productunit", product.getProductUnit());
	        map.put("safestock", product.getSafeStock());
	        map.put("lastpurdate", product.getLastPurDate());
	        map.put("lastdeldate", product.getLastDelDate());
	        map.put("quantity", product.getQuantity());
	        map.put("suggestbuyprice", product.getSuggestBuyPrice());
	        map.put("suggestsaleprice", product.getSuggestSalePrice());
	        map.put("supplierid", product.getSupplier().getSupplierID());
			return this.sqlSessionTemplate.update("product.productupdate", map);
		}
}
