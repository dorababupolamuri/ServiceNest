package com.service.nest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.nest.dao.ProfessionalUserD;
import com.service.nest.dao.ServiceType;

@Repository
public interface ProfessionalUserRepository extends JpaRepository<ProfessionalUserD, Long> {
	
	public List<ProfessionalUserD> findByServingCity(String servingCity);

	public List<ProfessionalUserD> findByServiceType(ServiceType type);
	
	
	

}
