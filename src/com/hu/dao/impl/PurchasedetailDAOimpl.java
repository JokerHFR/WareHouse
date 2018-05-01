package com.hu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.PurchasedetailDAO;
import com.hu.model.Purchasedetail;

public class PurchasedetailDAOimpl implements PurchasedetailDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public int insertpurchasedetail(Purchasedetail purchasedetail) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("FK_PurchaseID", purchasedetail.getPurchasemaster().getPurchaseID());
	        map.put("FK_ProductID", purchasedetail.getProduct().getProductID());
	        map.put("PurchaseQua", purchasedetail.getPurchaseQua());
	        map.put("PurchasePrice", purchasedetail.getPurchasePrice());
	        return this.sqlSessionTemplate.insert("purchasedetail.purchasedetailinsert",map);
		}
}
