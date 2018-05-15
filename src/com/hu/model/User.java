package com.hu.model;

public class User {
    private long userid;
    private String username;
    private String userword;;
    private int isuse;
    private int issuper;
    public  User(){
    	
    }
    public  User(long id,String username,String userword,int isuse){
    	this.userid=id;
    	this.username=username;
    	this.userword=userword;
    	this.isuse=isuse; 	
    }
    public long getUserid() {
        return userid;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUserword() {
        return userword;
    }
    public void setUserword(String userword) {
        this.userword = userword;
    }
	public int getIsuse() {
		return isuse;
	}
	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}
	public int getIssuper() {
		return issuper;
	}
	public void setIssuper(int issuper) {
		this.issuper = issuper;
	}
}


