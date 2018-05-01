package com.hu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.DeliverydetailDAO;
import com.hu.model.Deliverydetail;

public class DeliverydetailDAOimpl implements DeliverydetailDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public int insertdeliverydetail(Deliverydetail deliverydetail) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("FK_DeliveryID", deliverydetail.getDeliverymaster().getDeliveryID());
	        map.put("FK_ProductID", deliverydetail.getProduct().getProductID());
	        map.put("SalesQua", deliverydetail.getSalesQua());
	        map.put("SalesPrice", deliverydetail.getSalesPrice());
	        return this.sqlSessionTemplate.insert("deliverydetail.deliverydetailinsert",map);
		}
}
