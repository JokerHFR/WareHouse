package com.hu.dao;

import com.hu.model.User;

public interface UserDAO {
	public User login(String uname,String uword) throws Exception;
	public int register(String uname,String uword,int isuse) throws Exception;
	public int change(String uname, String uword);
}
