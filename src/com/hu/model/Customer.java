package com.hu.model;

import java.util.Date;

public class Customer {
	private long CustomerID;
    private String CustomerSimpleName;
    private String CustomerName;
    private String CustomerOwner;
    private String CustomerTitle;
    private String CustomerTele;
    private String CustomerMob;
    private String CustomerFax;
    private String CustomerAddress;
    private String DeliveryAddress;
    private String InvoiceAddress;
    private Date LastDeliveryDate;
    private Salesman Salesman;
    
    
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
	public String getCustomerTitle() {
		return CustomerTitle;
	}
	public void setCustomerTitle(String customerTitle) {
		CustomerTitle = customerTitle;
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
	public Salesman getSalesman() {
		return Salesman;
	}
	public void setSalesman(Salesman salesman) {
		Salesman = salesman;
	}
}
