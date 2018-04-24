package com.hu.model;

public class Buyer {
	private long UserID;
	public long getUserID() {
		return UserID;
	}
	public void setUserID(long userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPasswordCode() {
		return PasswordCode;
	}
	public void setPasswordCode(String passwordCode) {
		PasswordCode = passwordCode;
	}
	public int getIsUse() {
		return IsUse;
	}
	public void setIsUse(int isUse) {
		IsUse = isUse;
	}
	private String UserName;
	private String PasswordCode;
	private int IsUse;
}
