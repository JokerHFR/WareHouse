package com.hu.blservice;

import java.util.List;

import com.hu.model.Purchasedetail;

public interface PurchasedetailBL {
	/**
     * ��ӽ���������Ϣ
     * @param supplier ����������Ϣ
     * @return
     */
    public int insertpurchasedetail(List<Purchasedetail> purchasedetail);
}
