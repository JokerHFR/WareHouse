package com.hu.dao.impl;

import java.util.HashMap;
import java.util.List;
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
		public int register(String uname, String uword) throws Exception {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("uname", uname);
	        map.put("uword", uword);
	        return  this.sqlSessionTemplate.update("user.userRegister", map);
		}

		@Override
		public int change(String uname, String uword) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("uname", uname);
	        map.put("uword", uword);
	        return  this.sqlSessionTemplate.update("user.userChange", map);
			
		}

		@Override
		public int findregisterUser(String uname) throws Exception {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("uname", uname);
			int i=0;
			if(!(this.sqlSessionTemplate.selectOne("user.userFind", map)==null)){
				i=1;
			}
			return i;
		}

		@Override
		public  List<User> findUser() throws Exception {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("user.userallFind");
		}

		@Override
		public int deleteUser(String uname) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("uname", uname);
			return  this.sqlSessionTemplate.delete("user.userDelete", map);
		}

		@Override
		public int updateisUse(String uname) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("uname", uname);
			return  this.sqlSessionTemplate.update("user.isuseUpdate", map);
		}

		@Override
		public int updatenoUse(String uname) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("uname", uname);
			return  this.sqlSessionTemplate.update("user.nouseUpdate", map);
		}
}
