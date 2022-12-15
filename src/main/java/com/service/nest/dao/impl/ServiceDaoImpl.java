package com.service.nest.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.Service;
import com.service.nest.dao.ServiceDao;
import com.service.nest.dao.ServiceType;
import com.service.nest.repository.ServiceRepository;

@Component
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	private ServiceRepository serviceRepository;
	
	

	public ServiceRepository getServiceRepository() {
		return serviceRepository;
	}

	public void setServiceRepository(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@Override
	public Long saveService(Service service) {
		Service serv =  serviceRepository.save(service);
		return serv.getServiceId();
	}

	@Override
	public List<Service> getAllServices() {
		return serviceRepository.findAll();
	}

	@Override
	public Optional<Service> getServiceById(Long serviceId) {
		return serviceRepository.findById(serviceId);
	}

	@Override
	public List<String> getAllServiceTypes() {
		return null;
	}

	@Override
	public List<Service> getAllServicesByType(ServiceType serviceType) {
		return serviceRepository.findByServiceType(serviceType);
	}


	@Override
	public Service getServiceByName(String serviceName) {
		return serviceRepository.findByServiceName(serviceName);
	}

	

}
