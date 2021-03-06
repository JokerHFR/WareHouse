package com.hu.model;

public class Salesman {
	
	
	 private long SalesManID;
     private String SalesManName;
     private String SalesManTele;
     private String SalesManMob;
     private String SalesManAdd;
     private String SalesManEmail;
     
     public Salesman(){
    	 
     }
     
     public Salesman(String SalesManName,String SalesManTele,String SalesManMob,String SalesManAdd,String SalesManEmail){
    	 this.SalesManName=SalesManName;
    	 this.SalesManTele=SalesManTele;
    	 this.SalesManMob=SalesManMob;
    	 this.SalesManAdd=SalesManAdd;
    	 this.SalesManEmail=SalesManEmail;
     }
     
     public Salesman(long SalesManID,String SalesManName,String SalesManTele,String SalesManMob,String SalesManAdd,String SalesManEmail){
    	 this.SalesManID=SalesManID;
    	 this.SalesManName=SalesManName;
    	 this.SalesManTele=SalesManTele;
    	 this.SalesManMob=SalesManMob;
    	 this.SalesManAdd=SalesManAdd;
    	 this.SalesManEmail=SalesManEmail;
     }
     public long getSalesManID() {
		return SalesManID;
	}
	public void setSalesManID(long salesManID) {
		SalesManID = salesManID;
	}
	public String getSalesManName() {
		return SalesManName;
	}
	public void setSalesManName(String salesManName) {
		SalesManName = salesManName;
	}
	public String getSalesManTele() {
		return SalesManTele;
	}
	public void setSalesManTele(String salesManTele) {
		SalesManTele = salesManTele;
	}
	public String getSalesManMob() {
		return SalesManMob;
	}
	public void setSalesManMob(String salesManMob) {
		SalesManMob = salesManMob;
	}
	public String getSalesManAdd() {
		return SalesManAdd;
	}
	public void setSalesManAdd(String salesManAdd) {
		SalesManAdd = salesManAdd;
	}
	public String getSalesManEmail() {
		return SalesManEmail;
	}
	public void setSalesManEmail(String salesManEmail) {
		SalesManEmail = salesManEmail;
	}
	
}
