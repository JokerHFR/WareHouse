package com.hu.blservice;

import java.util.List;

import com.hu.model.User;

public interface UserBL {
	/**
	 * �û�����
	 * @param uname �û���
	 * @param uword ����
	 * @return
	 * @throws Exception
	 */
	public User findLogin(String uname,String uword) throws Exception;
    /**
     * �û�ע��
     * @param uname �û���
     * @param uword ����
     * @return
     * @throws Exception
     */
	public int registerUser(String uname,String uword) throws Exception;
	/**
	 * �û�������޸�
	 * @param uname �û���
	 * @param uword ������
	 * @return
	 * @throws Exception
	 */
	public int changePassword(String uname,String uword) throws Exception;
	/**
	 * �û�ע��ʱ�鿴�û����Ƿ��Ѿ���ע��
	 * @param uname�û���
	 * @return
	 * @throws Exception
	 */
	public int findregisterUser(String uname) throws Exception;
	/**
	 * ���������û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<User> findUser() throws Exception;
	/**
	 * ɾ���û�
	 * @param uname �û�������
	 * @return
	 */
	public int deleteUser(List<String>uname);
	/**
	 * �û����
	 * @param uname �û�������
	 * @return
	 */
	public int updateisUse(List<String>uname);
	/**
	 * �û���ֹ
	 * @param uname �û�������
	 * @return
	 */
	public int updatenoUse(List<String>uname);
}
