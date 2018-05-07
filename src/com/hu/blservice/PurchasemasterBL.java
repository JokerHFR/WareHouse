package com.hu.blservice;

import java.util.List;

import com.hu.model.Purchasemaster;

public interface PurchasemasterBL {
	/**
	 * 返回所有进货单信息
	 * @return
	 */
     public List<Purchasemaster> findAllpurchasemaster();
     /**
      * 批量删除进货单
      * @param supplierID 进货单编号的数组
      * @return
      */
     public int deletepurchasemaster(String[] purchasemasterID);
     /**
      * 添加进货单信息
      * @param supplier 进货单信息
      * @return
      */
     public int insertpurchasemaster(Purchasemaster purchasemaster);
     /**
      * 修改进货单信息
      * @param supplier 进货单信息
      * @return
      */
     public int updatepurchasemaster(List<Purchasemaster> purchasemaster);
}
