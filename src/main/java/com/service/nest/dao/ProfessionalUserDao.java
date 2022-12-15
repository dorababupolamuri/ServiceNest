package com.service.nest.dao;

import java.util.List;
import java.util.Optional;

import com.service.nest.exception.ServiceNestException;

public interface ProfessionalUserDao {

	public Long saveProfessionalUser(ProfessionalUserD user) throws ServiceNestException;

	public List<ProfessionalUserD> getAllEndUsers();

	public Optional<ProfessionalUserD> getEnduserById(Long endUserId);

	
	


}
