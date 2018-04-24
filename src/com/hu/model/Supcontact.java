package com.hu.model;

public class Supcontact {
    private long SupContactID;
    private String SupContactName;
    private String SupContactTitle;
    private String SupContactTele;
    private String SupContactMob;
    private Supplier Supplier;
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	public String getSupContactMob() {
		return SupContactMob;
	}
	public void setSupContactMob(String supContactMob) {
		SupContactMob = supContactMob;
	}
	public String getSupContactTele() {
		return SupContactTele;
	}
	public void setSupContactTele(String supContactTele) {
		SupContactTele = supContactTele;
	}
	public String getSupContactTitle() {
		return SupContactTitle;
	}
	public void setSupContactTitle(String supContactTitle) {
		SupContactTitle = supContactTitle;
	}
	public String getSupContactName() {
		return SupContactName;
	}
	public void setSupContactName(String supContactName) {
		SupContactName = supContactName;
	}
	public long getSupContactID() {
		return SupContactID;
	}
	public void setSupContactID(long supContactID) {
		SupContactID = supContactID;
	}
}
