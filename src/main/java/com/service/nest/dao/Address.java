package com.service.nest.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String streetAddress;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String Country;

	@Column(nullable = false)
	private Integer pinCode;

	@ManyToOne

	@JoinColumn(name = "user_id")
	private EndUser endUser;

	@ManyToOne

	@JoinColumn(name = "p_user_id")
	private ProfessionalUserD professionalUser;

	public ProfessionalUserD getProfessionalUser() {
		return professionalUser;
	}

	public void setProfessionalUser(ProfessionalUserD professionalUser) {
		this.professionalUser = professionalUser;
	}

	public Address() {
	}

	public Address(String streetAddress, String city, String country, Integer pinCode, EndUser endUser) {
		this.streetAddress = streetAddress;
		this.city = city;
		Country = country;
		this.pinCode = pinCode;
		this.endUser = endUser;
	}

	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

}
