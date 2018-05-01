package com.hu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.PurchasemasterDAO;
import com.hu.model.Purchasemaster;

public class PurchasemasterDAOimpl implements PurchasemasterDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public List<Purchasemaster> findAllpurchasemaster() {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("purchasemaster.purchasemasterfindAll");
		}

		@Override
		public int deletepurchasemaster(String purchasemasterID) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("purchasemasterid", purchasemasterID);
			return this.sqlSessionTemplate.delete("purchasemaster.purchasemasterdelete",map);
		}

		@Override
		public int insertpurchasemaster(Purchasemaster purchasemaster) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("PurchaseID", purchasemaster.getPurchaseID());
	        map.put("PurchaseDate", purchasemaster.getPurchaseDate());
	        map.put("PurchasePro", purchasemaster.getPurchasePro());
	        return this.sqlSessionTemplate.insert("purchasemaster.purchasemasterinsert",map);
		}

		@Override
		public int updatepurchasemaster(Purchasemaster purchasemaster) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("PurchaseID", purchasemaster.getPurchaseID());
	        map.put("PurchaseDate", purchasemaster.getPurchaseDate());
	        map.put("PurchasePro", purchasemaster.getPurchasePro());
	        return this.sqlSessionTemplate.update("purchasemaster.purchasemasterupdate",map);
		}
}
