package com.service.nest.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Integer userId;

	private String userName;
	
	private String address;
	
	private String emailId;
	
	private String dateOfBirth;
	
	private boolean isEndUser;

	public boolean isEndUser() {
		return isEndUser;
	}

	public void setEndUser(boolean isEndUser) {
		this.isEndUser = isEndUser;
	}
	
	public User() {
		super();
	}

	public User(String userName, String address, String emailId, String dateOfBirth, boolean isEndUser) {
		this.userName = userName;
		this.address = address;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.isEndUser = isEndUser;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
