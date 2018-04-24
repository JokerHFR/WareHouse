package com.hu.model;

public class Purchasedetail {
      private Purchasemaster Purchasemaster;
      private Product Product;
      private long PurchaseQua;
      private double PurchasePrice;
      
	public Purchasemaster getPurchasemaster() {
		return Purchasemaster;
	}
	public void setPurchasemaster(Purchasemaster purchasemaster) {
		Purchasemaster = purchasemaster;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	public long getPurchaseQua() {
		return PurchaseQua;
	}
	public void setPurchaseQua(long purchaseQua) {
		PurchaseQua = purchaseQua;
	}
	public double getPurchasePrice() {
		return PurchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		PurchasePrice = purchasePrice;
	}
}
