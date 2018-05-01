package com.hu.blservice;

import java.util.List;

import com.hu.model.Purchasedetail;

public interface PurchasedetailBL {
	/**
     * 添加进货附单信息
     * @param supplier 进货附单信息
     * @return
     */
    public int insertpurchasedetail(List<Purchasedetail> purchasedetail);
}
