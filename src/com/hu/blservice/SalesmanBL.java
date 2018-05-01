package com.hu.blservice;

import java.util.List;

import com.hu.model.Salesman;

public interface SalesmanBL {
	/**
	 * 返回所有销售员工信息
	 * @return
	 */
     public List<Salesman> findAllsalesman();
     /**
      * 批量删除员工
      * @param salesmanID 员工编号的数组
      * @return
      */
     public int deletesalesman(String[] salesmanID);
     /**
      * 添加员工信息
      * @param salseman 员工信息
      * @return
      */
     public int insertsalesman(List<Salesman> salseman);
     /**
      * 修改员工信息
      * @param salesman 员工信息
      * @return
      */
     public int updatesalesman(List<Salesman> salesman);
     
     
}
