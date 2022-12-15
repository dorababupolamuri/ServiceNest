package com.service.nest.domainI;

import java.util.List;

import com.service.nest.dao.ServiceType;

public class ProfessionalUser {

	private String name;

	private Long mobileNumber;

	private String emailId;

	private String password;

	private List<UserAddress> address;

	private String department;

	private String speciality;

	private String certificates;

	private boolean isAvailable;

	private Double experience;

	private Double overallRating;

	private String servingCity;

	private ServiceType serviceType;

	public ProfessionalUser() {
		super();
	}

	public ProfessionalUser(String name, Long mobileNumber, String emailId, String password, List<UserAddress> address,
			String department, String speciality, String certificates, boolean isAvailable, Double experience,
			Double overallRating, String servingCity, ServiceType serviceType) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		this.department = department;
		this.speciality = speciality;
		this.certificates = certificates;
		this.isAvailable = isAvailable;
		this.experience = experience;
		this.overallRating = overallRating;
		this.servingCity = servingCity;
		this.serviceType = serviceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserAddress> getAddress() {
		return address;
	}

	public void setAddress(List<UserAddress> address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCertificates() {
		return certificates;
	}

	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Double overallRating) {
		this.overallRating = overallRating;
	}

	public String getServingCity() {
		return servingCity;
	}

	public void setServingCity(String servingCity) {
		this.servingCity = servingCity;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

}