package com.hu.blservice;

import com.hu.model.User;

public interface UserBL {
	public User findLogin(String uname,String uword) throws Exception;
	public int registerUser(String uname,String uword,int isuse) throws Exception;
	public int changePassword(String uname,String uword) throws Exception;
}
