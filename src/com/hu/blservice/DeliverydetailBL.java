package com.hu.blservice;

import java.util.List;

import com.hu.model.Deliverydetail;

public interface DeliverydetailBL {
	/**
     * 添加销售附单信息
     * @param supplier 销售附单信息
     * @return
     */
    public int insertdeliverydetail(List<Deliverydetail> deliverydetail);
}
