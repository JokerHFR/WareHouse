package com.hu.blservice;

import java.util.List;

import com.hu.model.User;

public interface UserBL {
	/**
	 * 用户登入
	 * @param uname 用户名
	 * @param uword 密码
	 * @return
	 * @throws Exception
	 */
	public User findLogin(String uname,String uword) throws Exception;
    /**
     * 用户注册
     * @param uname 用户名
     * @param uword 密码
     * @return
     * @throws Exception
     */
	public int registerUser(String uname,String uword) throws Exception;
	/**
	 * 用户密码的修改
	 * @param uname 用户名
	 * @param uword 新密码
	 * @return
	 * @throws Exception
	 */
	public int changePassword(String uname,String uword) throws Exception;
	/**
	 * 用户注册时查看用户名是否已经被注册
	 * @param uname用户名
	 * @return
	 * @throws Exception
	 */
	public int findregisterUser(String uname) throws Exception;
	/**
	 * 返回所有用户信息
	 * @return
	 * @throws Exception
	 */
	public List<User> findUser() throws Exception;
	/**
	 * 删除用户
	 * @param uname 用户名数组
	 * @return
	 */
	public int deleteUser(List<String>uname);
	/**
	 * 用户解禁
	 * @param uname 用户名数组
	 * @return
	 */
	public int updateisUse(List<String>uname);
	/**
	 * 用户禁止
	 * @param uname 用户名数组
	 * @return
	 */
	public int updatenoUse(List<String>uname);
}
