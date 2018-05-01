package com.hu.dao;

import java.util.List;

import com.hu.model.Salesman;

public interface SalesmanDAO {
    public List<Salesman> findAllsalesman();
    
    public int deletesalesman(String salesmanID);
    
    public int insertsalesman(Salesman salesman);
    
    public int updatesalesman(Salesman salesman);
}
