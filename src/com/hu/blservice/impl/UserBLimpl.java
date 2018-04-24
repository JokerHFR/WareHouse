package com.hu.blservice.impl;

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
	public int registerUser(String uname, String uword, int isuse) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changePassword(String uname, String uword)
			throws Exception {
		// TODO Auto-generated method stub
		return userDAO.change(uname,uword);
	}
}
