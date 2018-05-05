package com.hu.model;

import java.util.Date;

public class Purchasemaster {
	private long PurchaseID;
	private Date PurchaseDate;
	private int PurchasePro;
	private double PurMoney;
	public Purchasemaster(){
		
	}
    public Purchasemaster(long PurchaseID,Date PurchaseDate,int PurchasePro,double PurMoney){
		this.PurchaseID=PurchaseID; 
		this.PurchaseDate=PurchaseDate;
		this.PurchasePro=PurchasePro;
		this.PurMoney=PurMoney;
	}
	public long getPurchaseID() {
		return PurchaseID;
	}
	public void setPurchaseID(long purchaseID) {
		PurchaseID = purchaseID;
	}
	public Date getPurchaseDate() {
		return PurchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		PurchaseDate = purchaseDate;
	}
	public int getPurchasePro() {
		return PurchasePro;
	}
	public void setPurchasePro(int purchasePro) {
		PurchasePro = purchasePro;
	}
	public double getPurMoney() {
		return PurMoney;
	}
	public void setPurMoney(double purMoney) {
		PurMoney = purMoney;
	}
}
