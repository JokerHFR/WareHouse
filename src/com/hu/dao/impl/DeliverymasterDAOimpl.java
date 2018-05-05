package com.hu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.DeliverymasterDAO;
import com.hu.model.Deliverymaster;

public class DeliverymasterDAOimpl implements DeliverymasterDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public List<Deliverymaster> findAlldeliverymaster() {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("deliverymaster.deliverymasterfindAll");
		}

		@Override
		public int deletedeliverymaster(String deliverymasterID) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("deliverymasterid", deliverymasterID);
			return this.sqlSessionTemplate.delete("deliverymaster.deliverymasterdelete",map);
		}

		@Override
		public int insertdeliverymaster(Deliverymaster deliverymaster) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("DeliveryID", deliverymaster.getDeliveryID());
	        map.put("DeliveryPro", deliverymaster.getDeliveryPro());
	        map.put("DeliveryDate", deliverymaster.getDeliveryDate());
	        map.put("FK_CustomerID", deliverymaster.getCustomer().getCustomerID());
	        map.put("FK_SalesManID", deliverymaster.getSalesman().getSalesManID());
	        map.put("DeliveryAddress", deliverymaster.getDeliveryAddress());
	        map.put("DelMoney", deliverymaster.getDelMoney());
	        return this.sqlSessionTemplate.insert("deliverymaster.deliverymasterinsert",map);
		}

		@Override
		public int updatedeliverymaster(Deliverymaster deliverymaster) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("DeliveryID", deliverymaster.getDeliveryID());
	        map.put("DeliveryPro", deliverymaster.getDeliveryPro());
	        map.put("DeliveryDate", deliverymaster.getDeliveryDate());
	        map.put("FK_CustomerID", deliverymaster.getCustomer().getCustomerID());
	        map.put("FK_SalesManID", deliverymaster.getSalesman().getSalesManID());
	        map.put("DeliveryAddress", deliverymaster.getDeliveryAddress());
	        map.put("DelMoney", deliverymaster.getDelMoney());
	        return this.sqlSessionTemplate.update("deliverymaster.deliverymasterupdate",map);
		}
}
