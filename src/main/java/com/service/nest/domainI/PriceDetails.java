package com.service.nest.domainI;

public class PriceDetails {

	private String serviceName;

	private String duration;

	private Integer count;

	private Double unitFare;

	private Double fare;

	public PriceDetails() {
		super();
	}

	public PriceDetails(String serviceName, String duration, Integer count, Double unitFare, Double fare) {
		super();
		this.serviceName = serviceName;
		this.duration = duration;
		this.count = count;
		this.unitFare = unitFare;
		this.fare = fare;
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
