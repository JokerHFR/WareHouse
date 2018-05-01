package com.hu.dao;

import java.util.List;

import com.hu.model.Deliverymaster;

public interface DeliverymasterDAO {
    public List<Deliverymaster> findAlldeliverymaster();
    
    public int deletedeliverymaster(String deliverymasterID);
    
    public int insertdeliverymaster(Deliverymaster deliverymaster);
    
    public int updatedeliverymaster(Deliverymaster deliverymaster);
}
