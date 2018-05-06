package com.hu.blservice;

import java.util.Date;
import java.util.List;

import com.hu.model.Product;


public interface ProductBL {
	/**
	 * ��������ʳƷ��Ϣ
	 * @return
	 */
     public List<Product> findAllproduct();
     /**
      * ����ָ����˾�ı��
      * @param supplierid ��˾���
      * @return
      */
     public List<Product> findproduct(String supplierid);
     /**
      * ����ɾ��ʳƷ
      * @param ProductID ʳƷ��ŵ�����
      * @return
      */
     public int deleteproduct(String[] ProductID);
     /**
      * ���ʳƷ��Ϣ
      * @param Product ʳƷ��Ϣ
      * @return
      */
     public int insertproduct(List<Product> Product);
     /**
      * �޸�ʳƷ��Ϣ
      * @param Product ʳƷ��Ϣ
      * @return
      */
     public int updateproduct(List<Product> Product);
     /**
      * �޸�ʳƷ��Ϣ
      * @param Product ʳƷ��Ϣ
      * @return
      */
     public int productupdatequa(List<Product> product,Date date);
     
     /**
      * �޸�ʳƷ��Ϣ
      * @param Product ʳƷ��Ϣ
      * @return
      */
     public int productupdatequa(List<Product> product,int i);
}
