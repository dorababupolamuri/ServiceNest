package com.service.nest.dao;

import java.util.List;
import java.util.Optional;

public interface ServiceDao {

	public Long saveService(Service service);

	public List<Service> getAllServices();

	public Optional<Service> getServiceById(Long serviceId);

	public List<String> getAllServiceTypes();

	public List<Service> getAllServicesByType(ServiceType serviceType);
	

	public Service getServiceByName(String serviceName);

}
