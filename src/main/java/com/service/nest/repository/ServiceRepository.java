package com.service.nest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.nest.dao.Service;
import com.service.nest.dao.ServiceType;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

	List<Service> findByServiceType(ServiceType serviceType);

	Service findByServiceName(String serviceName);

	
	
	
}
