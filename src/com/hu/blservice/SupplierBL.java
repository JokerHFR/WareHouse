package com.hu.blservice;

import java.util.Date;
import java.util.List;

import com.hu.model.Supplier;

public interface SupplierBL {
	/**
	 * �������й�Ӧ����Ϣ
	 * @return
	 */
     public List<Supplier> findAllsupplier();
     /**
      * ����ɾ����Ӧ��
      * @param supplierID ��Ӧ�̱�ŵ�����
      * @return
      */
     public int deletesupplier(String[] supplierID);
     /**
      * ��ӹ�Ӧ����Ϣ
      * @param supplier ��Ӧ����Ϣ
      * @return
      */
     public int insertsupplier(List<Supplier> supplier);
     /**
      * �޸Ĺ�Ӧ����Ϣ
      * @param supplier ��Ӧ����Ϣ
      * @return
      */
     public int updatesupplier(List<Supplier> supplier);
     /**
      * �޸Ĺ�Ӧ�̽�����Ϣ
      * @param supplier ��Ӧ����Ϣ
      * @return
      */
     public int updatesupplierdate(Supplier supplier,Date date);
     
}
