package com.hu.blservice;

import java.util.List;

import com.hu.model.Deliverymaster;

public interface DeliverymasterBL {
	/**
	 * �����������۵���Ϣ
	 * @return
	 */
     public List<Deliverymaster> findAlldeliverymaster();
     /**
      * ����ɾ�����۵�
      * @param supplierID ���۵���ŵ�����
      * @return
      */
     public int deletedeliverymaster(String[] deliverymasterID);
     /**
      * ������۵���Ϣ
      * @param supplier ���۵���Ϣ
      * @return
      */
     public int insertdeliverymaster(Deliverymaster deliverymaster);
     /**
      * �޸����۵���Ϣ
      * @param supplier ���۵���Ϣ
      * @return
      */
     public int updatedeliverymaster(List<Deliverymaster> deliverymaster);
}
