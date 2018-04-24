package com.hu.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.CuscontactmanDAO;

public class CuscontactmanDAOimpl implements CuscontactmanDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }
}
