package com.service.nest.dao;

public enum ServiceType {

	SALON_FOR_MEN("1"), SALON_FOR_WOMEN("2"), APPLIANCE_REPAIR("3"), CLEANING_AND_PEST_CONTROL("4"), ELECTRICIANS("5"),
	CARPENTERS("6"), PLUMBERS("7");

	private String serviceId;

	ServiceType(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public static ServiceType getServiceType(String serviceId) {
		for (ServiceType serv : ServiceType.values()) {
			if (serv.getServiceId().equals(serviceId)) {
				return serv;
			}
		}
		return null;
	}

}
