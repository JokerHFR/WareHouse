package com.hu.blservice;

import java.util.Date;
import java.util.List;

import com.hu.model.Supplier;

public interface SupplierBL {
	/**
	 * 返回所有供应商信息
	 * @return
	 */
     public List<Supplier> findAllsupplier();
     /**
      * 批量删除供应商
      * @param supplierID 供应商编号的数组
      * @return
      */
     public int deletesupplier(String[] supplierID);
     /**
      * 添加供应商信息
      * @param supplier 供应商信息
      * @return
      */
     public int insertsupplier(List<Supplier> supplier);
     /**
      * 修改供应商信息
      * @param supplier 供应商信息
      * @return
      */
     public int updatesupplier(List<Supplier> supplier);
     /**
      * 修改供应商进货信息
      * @param supplier 供应商信息
      * @return
      */
     public int updatesupplierdate(Supplier supplier,Date date);
     
}
