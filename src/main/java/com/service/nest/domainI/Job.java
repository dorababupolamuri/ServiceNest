package com.service.nest.domainI;

import com.service.nest.dao.ServiceType;

public class Job {

	private Double basePrice;

	private String timeRequired;

	private String name;

	private Double rating;

	private ServiceType type;

	public Job() {
	}
	
	
	

	public Job(Double basePrice, String timeRequired, String name, Double rating, ServiceType type) {
		super();
		this.basePrice = basePrice;
		this.timeRequired = timeRequired;
		this.name = name;
		this.rating = rating;
		this.type = type;
	}




	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public String getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(String timeRequired) {
		this.timeRequired = timeRequired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}
	
	
}