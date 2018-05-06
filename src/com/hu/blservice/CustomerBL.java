package com.hu.blservice;

import java.util.Date;
import java.util.List;

import com.hu.model.Customer;

public interface CustomerBL {
	/**
	 * �������пͻ���Ϣ
	 * @return
	 */
     public List<Customer> findAllcustomer();
     /**
      * ����ɾ���ͻ�
      * @param customerID �ͻ���ŵ�����
      * @return
      */
     public int deletecustomer(String[] customerID);
     /**
      * ��ӿͻ���Ϣ
      * @param customer �ͻ���Ϣ
      * @return
      */
     public int insertcustomer(List<Customer> customer);
     /**
      * �޸Ŀͻ���Ϣ
      * @param customer �ͻ���Ϣ
      * @return
      */
     public int updatecustomer(List<Customer> customer);
     /**
      * �޸Ŀͻ���������
      * @param customer �ͻ���Ϣ
      * @return
      */
     public int updatecustomerdate(Customer customer,Date date);
}
