package com.hu.model;

public class Cuscontactman {
       private long CusContactID;
       private String CusContactName;
       private String CusContactTitle;
       private String CusContactTele;
       private String CusContactMob;
       private  Customer Customer;
       
	public long getCusContactID() {
		return CusContactID;
	}
	public void setCusContactID(long cusContactID) {
		CusContactID = cusContactID;
	}
	public String getCusContactName() {
		return CusContactName;
	}
	public void setCusContactName(String cusContactName) {
		CusContactName = cusContactName;
	}
	public String getCusContactTitle() {
		return CusContactTitle;
	}
	public void setCusContactTitle(String cusContactTitle) {
		CusContactTitle = cusContactTitle;
	}
	public String getCusContactTele() {
		return CusContactTele;
	}
	public void setCusContactTele(String cusContactTele) {
		CusContactTele = cusContactTele;
	}
	public String getCusContactMob() {
		return CusContactMob;
	}
	public void setCusContactMob(String cusContactMob) {
		CusContactMob = cusContactMob;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
       
}
