package com.service.nest.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private Long serviceId;

	@Column(unique = true)
	private String serviceName;

	@Enumerated
	private ServiceType serviceType;

	private Double serviceCost;

	private Double serviceRating;

	private String serviceDuration;
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "crt_id") private Cart ct;
	 */

	public Service() {
		super();
	}

	public Service(String serviceName, ServiceType serviceType, Double serviceCost, Double serviceRating,
			String serviceDuration) {
		this.serviceName = serviceName;
		this.serviceType = serviceType;
		this.serviceCost = serviceCost;
		this.serviceRating = serviceRating;
		this.serviceDuration = serviceDuration;
	}
	
	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public Double getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(Double serviceRating) {
		this.serviceRating = serviceRating;
	}

	public String getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

}
