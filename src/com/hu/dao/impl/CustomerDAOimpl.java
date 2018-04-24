package com.hu.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.CustomerDAO;

public class CustomerDAOimpl implements CustomerDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }
}
