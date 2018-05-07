package com.hu.dao;

import java.util.Date;
import java.util.List;

import com.hu.model.Supplier;

public interface SupplierDAO {
    public List<Supplier> findAllsupplier();
    
    public int deletesupplier(String supplierID);
    
    public int insertsupplier(Supplier salesman);
    
    public int updatesupplier(Supplier salesman);
    
    public int updatesupplierdate(Supplier supplier,Date date);
}
