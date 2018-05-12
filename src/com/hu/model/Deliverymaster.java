package com.hu.model;

import java.util.Date;
import java.util.List;


public class Deliverymaster {
    private long DeliveryID;
    private int DeliveryPro;
    private Date DeliveryDate;
    private Customer Customer;
    private Salesman Salesman;
    private String DeliveryAddress;
    private double DelMoney;
    private List<Deliverydetail> Deliverydetail;
    
    public Deliverymaster(){
    	
    }
    public Deliverymaster(long DeliveryID,int DeliveryPro,Date date,Customer Customer,Salesman Salesman,String DeliveryAddress,double DelMoney){
    	this.DeliveryID=DeliveryID;
    	this.DeliveryPro=DeliveryPro;
    	this.DeliveryDate=date;
    	this.Customer=Customer;
    	this.Salesman=Salesman;
    	this.DeliveryAddress=DeliveryAddress;
    	this.DelMoney=DelMoney;
    	
    }
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
	public double getDelMoney() {
		return DelMoney;
	}
	public void setDelMoney(double delMoney) {
		DelMoney = delMoney;
	}
	public List<Deliverydetail> getDeliverydetail() {
		return Deliverydetail;
	}
	public void setDeliverydetail(List<Deliverydetail> deliverydetail) {
		Deliverydetail = deliverydetail;
	}
}
