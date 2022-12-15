package com.service.nest.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.ProfessionalUserD;
import com.service.nest.dao.ProfessionalUserDao;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.ProfessionalUserRepository;

@Component
public class ProfessionalUserDaoImpl implements ProfessionalUserDao {
	
	@Autowired
	private ProfessionalUserRepository professionalUserRepository;
	
	

	public ProfessionalUserRepository getProfessionalUserRepository() {
		return professionalUserRepository;
	}

	public void setProfessionalUserRepository(ProfessionalUserRepository professionalUserRepository) {
		this.professionalUserRepository = professionalUserRepository;
	}

	@Override
	public Long saveProfessionalUser(ProfessionalUserD user) throws ServiceNestException {
		
		ProfessionalUserD professionalUser = professionalUserRepository.save(user);
		return professionalUser.getpUserId();
	}

	@Override
	public List<ProfessionalUserD> getAllEndUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProfessionalUserD> getEnduserById(Long endUserId) {
		// TODO Auto-generated method stub
		return null;
	}



}
