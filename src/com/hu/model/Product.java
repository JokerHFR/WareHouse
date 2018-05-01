package com.hu.model;

import java.util.Date;

public class Product {
   private long ProductID;
   private String ProductName;
   private String ProductUnit;
   private long SafeStock;
   private Date LastPurDate;
   private Date LastDelDate;
   private long Quantity;
   private double SuggestBuyPrice;
   private double SuggestSalePrice;
   private long FK_SupplierID;
   private Supplier supplier;
   
   public Product( long ProductID,
   String ProductName,
   String ProductUnit,
   long SafeStock,
   Date LastPurDate,
   Date LastDelDate,
   long Quantity,
   double SuggestBuyPrice,
   double SuggestSalePrice,
   Supplier supplier){
	   
	   this.ProductID=ProductID;
	   this.ProductName=ProductName;
	   this.ProductUnit=ProductUnit;
	   this.SafeStock=SafeStock;
	   this.LastPurDate=LastPurDate;
	   this.LastDelDate=LastDelDate;
	   this.Quantity=Quantity;
	   this.SuggestBuyPrice=ProductID;
	   this.SuggestSalePrice=SuggestSalePrice;
	   this.supplier=supplier;
   }
   public Product(){
	   
   }
public long getProductID() {
	return ProductID;
}
public void setProductID(long productID) {
	ProductID = productID;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public String getProductUnit() {
	return ProductUnit;
}
public void setProductUnit(String productUnit) {
	ProductUnit = productUnit;
}
public long getSafeStock() {
	return SafeStock;
}
public void setSafeStock(long safeStock) {
	SafeStock = safeStock;
}
public Date getLastPurDate() {
	return LastPurDate;
}
public void setLastPurDate(Date lastPurDate) {
	LastPurDate = lastPurDate;
}
public Date getLastDelDate() {
	return LastDelDate;
}
public void setLastDelDate(Date lastDelDate) {
	LastDelDate = lastDelDate;
}
public long getQuantity() {
	return Quantity;
}
public void setQuantity(long quantity) {
	Quantity = quantity;
}
public double getSuggestBuyPrice() {
	return SuggestBuyPrice;
}
public void setSuggestBuyPrice(double suggestBuyPrice) {
	SuggestBuyPrice = suggestBuyPrice;
}
public double getSuggestSalePrice() {
	return SuggestSalePrice;
}
public void setSuggestSalePrice(double suggestSalePrice) {
	SuggestSalePrice = suggestSalePrice;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public long getFK_SupplierID() {
	return FK_SupplierID;
}
public void setFK_SupplierID(long fK_SupplierID) {
	FK_SupplierID = fK_SupplierID;
}
}
