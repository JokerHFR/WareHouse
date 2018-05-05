package com.hu.blservice;

import java.util.List;

import com.hu.model.Deliverymaster;

public interface DeliverymasterBL {
	/**
	 * 返回所有销售单信息
	 * @return
	 */
     public List<Deliverymaster> findAlldeliverymaster();
     /**
      * 批量删除销售单
      * @param supplierID 销售单编号的数组
      * @return
      */
     public int deletedeliverymaster(String[] deliverymasterID);
     /**
      * 添加销售单信息
      * @param supplier 销售单信息
      * @return
      */
     public int insertdeliverymaster(Deliverymaster deliverymaster);
     /**
      * 修改销售单信息
      * @param supplier 销售单信息
      * @return
      */
     public int updatedeliverymaster(List<Deliverymaster> deliverymaster);
}
