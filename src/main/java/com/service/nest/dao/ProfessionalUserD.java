package com.service.nest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "professionalusers")
public class ProfessionalUserD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_user_id")
	private Long pUserId;

	@NotNull
	private String userName;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "uv_id")
	private UserVault userVault;

	@OneToMany(mappedBy = "professionalUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> address = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderDetails orderDetails;

	@Column(length = 10)
	private Long mobileNumber;

	private String department;

	private String speciality;

	private String certificates;

	private boolean isAvailable;

	@Column(nullable = false)
	private Double experience;

	private Double overallRating;

	@Column(nullable = false)
	private String servingCity;
	@Enumerated
	private ServiceType serviceType;

	public ProfessionalUserD() {
		super();
	}

	public ProfessionalUserD(@NotNull String userName, @NotNull String password, List<Address> address,
			OrderDetails orderDetails, Long mobileNumber, String department, String speciality, String certificates,
			boolean isAvailable, String email, Double experience, Double overallRating, String servingCity,
			ServiceType serviceType) {
		super();
		this.userName = userName;
		this.address = address;
		this.orderDetails = orderDetails;
		this.mobileNumber = mobileNumber;
		this.department = department;
		this.speciality = speciality;
		this.certificates = certificates;
		this.isAvailable = isAvailable;
		this.experience = experience;
		this.overallRating = overallRating;
		this.servingCity = servingCity;
		this.serviceType = serviceType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public UserVault getUserVault() {
		return userVault;
	}

	public void setUserVault(UserVault userVault) {
		this.userVault = userVault;
	}

	public Long getpUserId() {
		return pUserId;
	}

}