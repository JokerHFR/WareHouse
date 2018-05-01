package com.hu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.hu.dao.SalesmanDAO;
import com.hu.model.Salesman;

public class SalesmanDAOimpl implements SalesmanDAO{
	   private SqlSessionTemplate sqlSessionTemplate;
	    
	    public SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }

		@Override
		public List<Salesman> findAllsalesman() {
			// TODO Auto-generated method stub
			return this.sqlSessionTemplate.selectList("salesman.salesmanfindAll");
		}

		@Override
		public int deletesalesman(String i) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
	        map.put("salesmanid", i);
			return this.sqlSessionTemplate.delete("salesman.salesmandelete",map);
		}

		@Override
		public int insertsalesman(Salesman salesman) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("salesmanid", salesman.getSalesManID());
	        map.put("salesmanname", salesman.getSalesManName());
	        map.put("salesmantele", salesman.getSalesManTele());
	        map.put("salesmanmob", salesman.getSalesManMob());
	        map.put("salesmanadd", salesman.getSalesManAdd());
	        map.put("salesmanemail", salesman.getSalesManEmail());
	        return this.sqlSessionTemplate.insert("salesman.salesmaninsert",map);
		}

		@Override
		public int updatesalesman(Salesman salesman) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("salesmanid", salesman.getSalesManID());
	        map.put("salesmanname", salesman.getSalesManName());
	        map.put("salesmantele", salesman.getSalesManTele());
	        map.put("salesmanmob", salesman.getSalesManMob());
	        map.put("salesmanadd", salesman.getSalesManAdd());
	        map.put("salesmanemail", salesman.getSalesManEmail());
			return this.sqlSessionTemplate.update("salesman.salesmanupdate",map);
		}
}
