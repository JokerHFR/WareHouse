package com.hu.model;

public class User {
    private long userid;
    private String username;
    private String userword;;
    private int isuse;
    
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
}


