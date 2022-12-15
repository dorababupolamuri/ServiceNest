package com.service.nest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@OneToMany(mappedBy = "orderDtls", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ServiceCost> serviceCost;

	private Double taxes;

	private Double grandTotal;

	private Long addressId;

	//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "orderDetails")
	@OneToMany(mappedBy = "orderDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProfessionalUserD> assignedProfessional = new ArrayList<>();

	public OrderDetails() {
		super();
	}

	public OrderDetails(List<ServiceCost> serviceCost, Double taxes, Double grandTotal,
			List<ProfessionalUserD> assignedProfessional) {
		super();
		this.serviceCost = serviceCost;
		this.taxes = taxes;
		this.grandTotal = grandTotal;
		this.assignedProfessional = assignedProfessional;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<ServiceCost> getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(List<ServiceCost> serviceCost) {
		this.serviceCost = serviceCost;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	
	public Long getOrderId() {
		return orderId;
	}

	public List<ProfessionalUserD> getAssignedProfessional() {
		return assignedProfessional;
	}

	public void setAssignedProfessional(List<ProfessionalUserD> assignedProfessional) {
		this.assignedProfessional = assignedProfessional;
	}
	
	

}
