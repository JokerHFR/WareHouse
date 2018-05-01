package com.hu.model;

import java.util.Date;

public class Supplier {
	
	   private long SupplierID;
	   private String SupplierSimpleName;
	   private String SupplierName;
	   private String SupplierOwner;
	   private String SupplierTele;
	   private String SupplierMob;
	   private String SupplierFax;
	   private String SuppliercomAddress;
	   private String SupplierFacAddress;
	   private Date SupplierLastPurDate;
	   
	   public Supplier(){
		   
	   }
	   public Supplier(long SupplierID,String SupplierSimpleName,String SupplierName,String SupplierOwner,
		        String SupplierTele,String SupplierMob,String SupplierFax,String SuppliercomAddress,String SupplierFacAddress,
               Date SupplierLastPurDate){
	this.SupplierID=SupplierID;
	this.SupplierSimpleName=SupplierSimpleName;
	this.SupplierName=SupplierName;
	this.SupplierOwner=SupplierOwner;
	this.SupplierTele=SupplierTele;
	this.SupplierMob=SupplierMob;
	this.SupplierFax=SupplierFax;
	this.SuppliercomAddress=SuppliercomAddress;
	this.SupplierFacAddress=SupplierFacAddress;
	this.SupplierLastPurDate=SupplierLastPurDate;
	   }
	   
   public long getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(long supplierID) {
		SupplierID = supplierID;
	}
	public String getSupplierSimpleName() {
		return SupplierSimpleName;
	}
	public void setSupplierSimpleName(String supplierSimpleName) {
		SupplierSimpleName = supplierSimpleName;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierOwner() {
		return SupplierOwner;
	}
	public void setSupplierOwner(String supplierOwner) {
		SupplierOwner = supplierOwner;
	}
	public String getSupplierTele() {
		return SupplierTele;
	}
	public void setSupplierTele(String supplierTele) {
		SupplierTele = supplierTele;
	}
	public String getSupplierMob() {
		return SupplierMob;
	}
	public void setSupplierMob(String supplierMob) {
		SupplierMob = supplierMob;
	}
	public String getSupplierFax() {
		return SupplierFax;
	}
	public void setSupplierFax(String supplierFax) {
		SupplierFax = supplierFax;
	}
	public String getSuppliercomAddress() {
		return SuppliercomAddress;
	}
	public void setSuppliercomAddress(String suppliercomAddress) {
		SuppliercomAddress = suppliercomAddress;
	}
	public String getSupplierFacAddress() {
		return SupplierFacAddress;
	}
	public void setSupplierFacAddress(String supplierFacAddress) {
		SupplierFacAddress = supplierFacAddress;
	}
	public Date getSupplierLastPurDate() {
		return SupplierLastPurDate;
	}
	public void setSupplierLastPurDate(Date supplierLastPurDate) {
		SupplierLastPurDate = supplierLastPurDate;
	}
   
}
