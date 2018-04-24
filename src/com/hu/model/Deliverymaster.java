package com.hu.model;

import java.sql.Date;

public class Deliverymaster {
    private long DeliveryID;
    private int DeliveryPro;
    private Date DeliveryDate;
    private Customer Customer;
    private Salesman Salesman;
    private String DeliveryAddress;
	public long getDeliveryID() {
		return DeliveryID;
	}
	public void setDeliveryID(long deliveryID) {
		DeliveryID = deliveryID;
	}
	public int getDeliveryPro() {
		return DeliveryPro;
	}
	public void setDeliveryPro(int deliveryPro) {
		DeliveryPro = deliveryPro;
	}
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	public Salesman getSalesman() {
		return Salesman;
	}
	public void setSalesman(Salesman salesman) {
		Salesman = salesman;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}
}
