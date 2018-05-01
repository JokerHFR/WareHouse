package com.hu.blservice;

import java.util.List;

import com.hu.model.Salesman;

public interface SalesmanBL {
	/**
	 * ������������Ա����Ϣ
	 * @return
	 */
     public List<Salesman> findAllsalesman();
     /**
      * ����ɾ��Ա��
      * @param salesmanID Ա����ŵ�����
      * @return
      */
     public int deletesalesman(String[] salesmanID);
     /**
      * ���Ա����Ϣ
      * @param salseman Ա����Ϣ
      * @return
      */
     public int insertsalesman(List<Salesman> salseman);
     /**
      * �޸�Ա����Ϣ
      * @param salesman Ա����Ϣ
      * @return
      */
     public int updatesalesman(List<Salesman> salesman);
     
     
}
