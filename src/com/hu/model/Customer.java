package com.hu.model;

import java.util.Date;

public class Customer {
	private long CustomerID;
    private String CustomerSimpleName;
    private String CustomerName;
    private String CustomerOwner;
    private String CustomerTele;
    private String CustomerMob;
    private String CustomerFax;
    private String CustomerAddress;
    private String DeliveryAddress;
    private String InvoiceAddress;
    private Date LastDeliveryDate;
    
    public Customer(){
    	
    }
    public Customer(long CustomerID,String CustomerSimpleName,String CustomerName,String CustomerOwner,
    		        String CustomerTele,String CustomerMob,String CustomerFax,String CustomerAddress,String DeliveryAddress,
                    String InvoiceAddress,Date LastDeliveryDate){
    	this.CustomerID=CustomerID;
    	this.CustomerSimpleName=CustomerSimpleName;
    	this.CustomerName=CustomerName;
    	this.CustomerOwner=CustomerOwner;
    	this.CustomerTele=CustomerTele;
    	this.CustomerMob=CustomerMob;
    	this.CustomerFax=CustomerFax;
    	this.CustomerAddress=CustomerAddress;
    	this.DeliveryAddress=DeliveryAddress;
    	this.InvoiceAddress=InvoiceAddress;
    	this.LastDeliveryDate=LastDeliveryDate;
    	
    }
	public long getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(long customerID) {
		CustomerID = customerID;
	}
	public String getCustomerSimpleName() {
		return CustomerSimpleName;
	}
	public void setCustomerSimpleName(String customerSimpleName) {
		CustomerSimpleName = customerSimpleName;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerOwner() {
		return CustomerOwner;
	}
	public void setCustomerOwner(String customerOwner) {
		CustomerOwner = customerOwner;
	}
	public String getCustomerTele() {
		return CustomerTele;
	}
	public void setCustomerTele(String customerTele) {
		CustomerTele = customerTele;
	}
	public String getCustomerMob() {
		return CustomerMob;
	}
	public void setCustomerMob(String customerMob) {
		CustomerMob = customerMob;
	}
	public String getCustomerFax() {
		return CustomerFax;
	}
	public void setCustomerFax(String customerFax) {
		CustomerFax = customerFax;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}
	public String getInvoiceAddress() {
		return InvoiceAddress;
	}
	public void setInvoiceAddress(String invoiceAddress) {
		InvoiceAddress = invoiceAddress;
	}
	public Date getLastDeliveryDate() {
		return LastDeliveryDate;
	}
	public void setLastDeliveryDate(Date lastDeliveryDate) {
		LastDeliveryDate = lastDeliveryDate;
	}
}
