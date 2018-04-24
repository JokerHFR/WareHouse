package com.hu.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.PurchasemasterDAO;

public class PurchasemasterDAOimpl implements PurchasemasterDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }
}
