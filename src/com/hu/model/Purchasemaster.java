package com.hu.model;

import java.util.Date;

public class Purchasemaster {
	private long PurchaseID;
	private Date PurchaseDate;
	private int PurchasePro;
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
}
