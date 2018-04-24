package com.hu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.UserDAO;
import com.hu.model.User;

public class UserDAOimpl implements UserDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public User login(String uname, String uword) throws Exception {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("uname", uname);
	        map.put("uword", uword);
	        return  this.sqlSessionTemplate.selectOne("user.userLogin", map);
		}

		@Override
		public int register(String uname, String uword, int isuse) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int change(String uname, String uword) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("uname", uname);
	        map.put("uword", uword);
	        return  this.sqlSessionTemplate.update("user.userChange", map);
			
		}
}
