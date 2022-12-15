package com.service.nest.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServiceCost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceCostId;

	private String serviceName;

	private String duration;

	private Integer count;

	private Double unitFare;

	private Double fare;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderDetails orderDtls;

	public ServiceCost() {
		super();
	}

	public ServiceCost(String serviceName, String duration, Integer count, Double unitFare, Double fare,
			OrderDetails orderDtls) {
		super();
		this.serviceName = serviceName;
		this.duration = duration;
		this.count = count;
		this.unitFare = unitFare;
		this.fare = fare;
		this.orderDtls = orderDtls;
	}

	public OrderDetails getOrderDtls() {
		return orderDtls;
	}

	public void setOrderDtls(OrderDetails orderDtls) {
		this.orderDtls = orderDtls;
	}

	public void setServiceCostId(Long serviceCostId) {
		this.serviceCostId = serviceCostId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getUnitFare() {
		return unitFare;
	}

	public void setUnitFare(Double unitFare) {
		this.unitFare = unitFare;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

}
