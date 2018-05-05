package com.hu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.SupplierDAO;
import com.hu.model.Supplier;

public class SupplierDAOimpl implements SupplierDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

	    @Override
		public List<Supplier> findAllsupplier() {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("supplier.supplierfindAllProduct");
		}

		@Override
		public int deletesupplier(String i) {
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("supplierid", i);
			return this.sqlSessionTemplate.delete("supplier.supplierdelete",map);
		}

		@Override
		public int insertsupplier(Supplier supplier) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("SupplierID", supplier.getSupplierID());
	        map.put("SupplierSimpleName", supplier.getSupplierSimpleName());
	        map.put("SupplierName", supplier.getSupplierName());
	        map.put("SupplierOwner", supplier.getSupplierOwner());
	        map.put("SupplierTele", supplier.getSupplierTele());
	        map.put("SupplierMob", supplier.getSupplierMob());
	        map.put("SupplierFax", supplier.getSupplierFax());
	        map.put("SuppliercomAddress", supplier.getSuppliercomAddress());
	        map.put("SupplierFacAddress", supplier.getSupplierFacAddress());
	        map.put("SupplierLastPurDate", supplier.getSupplierLastPurDate());
	        return this.sqlSessionTemplate.insert("supplier.supplierinsert",map);
		}

		@Override
		public int updatesupplier(Supplier supplier) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("SupplierID", supplier.getSupplierID());
	        map.put("SupplierSimpleName", supplier.getSupplierSimpleName());
	        map.put("SupplierName", supplier.getSupplierName());
	        map.put("SupplierOwner", supplier.getSupplierOwner());
	        map.put("SupplierTele", supplier.getSupplierTele());
	        map.put("SupplierMob", supplier.getSupplierMob());
	        map.put("SupplierFax", supplier.getSupplierFax());
	        map.put("SuppliercomAddress", supplier.getSuppliercomAddress());
	        map.put("SupplierFacAddress", supplier.getSupplierFacAddress());
	        map.put("SupplierLastPurDate", supplier.getSupplierLastPurDate());
			return this.sqlSessionTemplate.update("supplier.supplierupdate",map);
		}

}
