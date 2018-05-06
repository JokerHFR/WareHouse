package com.hu.blservice;

import java.util.Date;
import java.util.List;

import com.hu.model.Product;


public interface ProductBL {
	/**
	 * 返回所有食品信息
	 * @return
	 */
     public List<Product> findAllproduct();
     /**
      * 返回指定公司的编号
      * @param supplierid 公司编号
      * @return
      */
     public List<Product> findproduct(String supplierid);
     /**
      * 批量删除食品
      * @param ProductID 食品编号的数组
      * @return
      */
     public int deleteproduct(String[] ProductID);
     /**
      * 添加食品信息
      * @param Product 食品信息
      * @return
      */
     public int insertproduct(List<Product> Product);
     /**
      * 修改食品信息
      * @param Product 食品信息
      * @return
      */
     public int updateproduct(List<Product> Product);
     /**
      * 修改食品信息
      * @param Product 食品信息
      * @return
      */
     public int productupdatequa(List<Product> product,Date date);
     
     /**
      * 修改食品信息
      * @param Product 食品信息
      * @return
      */
     public int productupdatequa(List<Product> product,int i);
}
