package com.hu.dao;

import java.util.List;

import com.hu.model.Purchasemaster;

public interface PurchasemasterDAO {
    public List<Purchasemaster> findAllpurchasemaster();
    
    public int deletepurchasemaster(String purchasemasterID);
    
    public int insertpurchasemaster(Purchasemaster purchasemaster);
    
    public int updatepurchasemaster(Purchasemaster purchasemaster);
}
