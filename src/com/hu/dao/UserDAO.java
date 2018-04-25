package com.hu.dao;

import java.util.List;

import com.hu.model.User;

public interface UserDAO {
	public User login(String uname,String uword) throws Exception;
	public int register(String uname,String uword) throws Exception;
	public int change(String uname, String uword);
	public int findregisterUser(String uname) throws Exception;
	public List<User> findUser() throws Exception;
	public int deleteUser(String uname);
	public int updateisUse(String uname);
	public int updatenoUse(String uname);
}
