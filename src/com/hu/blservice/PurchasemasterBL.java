package com.hu.blservice;

import java.util.List;

import com.hu.model.Purchasemaster;

public interface PurchasemasterBL {
	/**
	 * �������н�������Ϣ
	 * @return
	 */
     public List<Purchasemaster> findAllpurchasemaster();
     /**
      * ����ɾ��������
      * @param supplierID ��������ŵ�����
      * @return
      */
     public int deletepurchasemaster(String[] purchasemasterID);
     /**
      * ��ӽ�������Ϣ
      * @param supplier ��������Ϣ
      * @return
      */
     public int insertpurchasemaster(Purchasemaster purchasemaster);
     /**
      * �޸Ľ�������Ϣ
      * @param supplier ��������Ϣ
      * @return
      */
     public int updatepurchasemaster(List<Purchasemaster> purchasemaster);
}
