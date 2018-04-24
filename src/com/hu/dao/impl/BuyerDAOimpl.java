package com.hu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.BuyerDAO;
import com.hu.model.Buyer;

public class BuyerDAOimpl implements BuyerDAO { 
    
    private SqlSessionTemplate sqlSessionTemplate;
    
    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public Buyer login(String uname, String uword) throws Exception { 
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("uname", uname);
        map.put("uword", uword);
        return this.sqlSessionTemplate.selectOne("buyer.buyerLogin", map);
    }

	@Override
	public int register(String uname, String uword) throws Exception {
	        Map<String,Object> map=new HashMap<String, Object>();
	        map.put("uname", uname);
	        map.put("uword", uword);
	        return this.sqlSessionTemplate.insert("buyer.buyerRegister", map);
	    }

	@Override
	public int information(long id, String uname, String sex, String date,
			String tele, String email) throws Exception {
		 Map<String,Object> map=new HashMap<String, Object>();
		 map.put("id", id);
	        map.put("uname", uname);
	        map.put("sex", sex);
	        map.put("date", date);
	        map.put("tele", tele);
	        map.put("email", email);
	        return this.sqlSessionTemplate.update("buyer.buyerInformation", map);
	}
	}

