package com.hu.blservice;

import java.util.List;

import com.hu.model.Deliverydetail;

public interface DeliverydetailBL {
	/**
     * ������۸�����Ϣ
     * @param supplier ���۸�����Ϣ
     * @return
     */
    public int insertdeliverydetail(List<Deliverydetail> deliverydetail);
}
