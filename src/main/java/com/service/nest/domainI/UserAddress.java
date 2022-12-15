package com.service.nest.domainI;

public class UserAddress {

	private String streetAddress;
	private String city;
	private String Country;
	private Integer zipCode;

	private User user;
	
	private ProfessionalUser pUser;

	public UserAddress() {
	}

	public UserAddress(String streetAddress, String city, String country, Integer zipCode, User user) {
		this.streetAddress = streetAddress;
		this.city = city;
		Country = country;
		this.zipCode = zipCode;
		this.user = user;
	}
	
	

	public ProfessionalUser getpUser() {
		return pUser;
	}

	public void setpUser(ProfessionalUser pUser) {
		this.pUser = pUser;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
