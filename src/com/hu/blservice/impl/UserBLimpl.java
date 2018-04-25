package com.hu.blservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hu.blservice.UserBL;
import com.hu.dao.UserDAO;
import com.hu.model.User;

public class UserBLimpl implements UserBL{
    @Autowired()
    @Qualifier("userDAOimpl")
    private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findLogin(String uname, String uword) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.login(uname, uword);
	}

	@Override
	public int registerUser(String uname, String uword) throws Exception {
		// TODO Auto-generated method stub
		int i=0;
		if(this.findregisterUser(uname)==0){
			i=this.userDAO.register(uname, uword);
		}else if(this.findregisterUser(uname)==1){
			i=2;
		}
		return i;
	}

	@Override
	public int changePassword(String uname, String uword)
			throws Exception {
		// TODO Auto-generated method stub
		return userDAO.change(uname,uword);
	}

	@Override
	public int findregisterUser(String uname) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findregisterUser(uname);
	}

	@Override
	public List<User> findUser() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findUser();
	}

	@Override
	public int deleteUser(List<String> uname) {
		// TODO Auto-generated method stub
		int a=0;
		for(int i=0;i<uname.size();i++){
			a=this.userDAO.deleteUser(uname.get(i));
		}
		return a;
	}

	@Override
	public int updateisUse(List<String> uname) {
		// TODO Auto-generated method stub
		int a=0;
		for(int i=0;i<uname.size();i++){
			a=this.userDAO.updateisUse(uname.get(i));
		}
		return a;
	}

	@Override
	public int updatenoUse(List<String> uname) {
		// TODO Auto-generated method stub
		int a=0;
		for(int i=0;i<uname.size();i++){
			a=this.userDAO.updatenoUse(uname.get(i));
		}
		return a;
	}
}
