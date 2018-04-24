package com.hu.model;

public class Deliverydetail {
   private Deliverymaster Deliverymaster;
   private Product Product;
   private long SalesQua;
   private double SalesPrice;
   
public Deliverymaster getDeliverymaster() {
	return Deliverymaster;
}
public void setDeliverymaster(Deliverymaster deliverymaster) {
	Deliverymaster = deliverymaster;
}
public Product getProduct() {
	return Product;
}
public void setProduct(Product product) {
	Product = product;
}
public long getSalesQua() {
	return SalesQua;
}
public void setSalesQua(long salesQua) {
	SalesQua = salesQua;
}
public double getSalesPrice() {
	return SalesPrice;
}
public void setSalesPrice(double salesPrice) {
	SalesPrice = salesPrice;
}
}
