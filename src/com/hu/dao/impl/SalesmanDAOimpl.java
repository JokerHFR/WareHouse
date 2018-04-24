package com.hu.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.SalesmanDAO;

public class SalesmanDAOimpl implements SalesmanDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }
}
