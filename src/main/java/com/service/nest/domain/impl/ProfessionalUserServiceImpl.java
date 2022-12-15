
package com.service.nest.domain.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.nest.dao.Address;
import com.service.nest.dao.ProfessionalUserD;
import com.service.nest.dao.ProfessionalUserDao;
import com.service.nest.dao.ServiceType;
import com.service.nest.dao.UserVault;
import com.service.nest.dao.UserVaultDao;
import com.service.nest.domainI.LoginUser;
import com.service.nest.domainI.ProfessionalUser;
import com.service.nest.domainI.ProfessionalUserService;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.ProfessionalUserRepository;
import com.service.nest.util.ServiceUtils;

@Service
public class ProfessionalUserServiceImpl implements ProfessionalUserService {
	
	@Autowired
	private ProfessionalUserRepository repos;

	@Autowired
	private ProfessionalUserDao pUserDao;

	@Autowired
	private UserVaultDao userVaultDao;
	
	// for junit testing
	

	@Override
	public Long registerNewProfessionalUser(ProfessionalUser pUser) throws ServiceNestException {

		if (isEmailIdAlreadyInUse(pUser)) {
			throw new ServiceNestException("Email id already in use, please sign in or click forgot password.");
		}
		ProfessionalUserD profUserD =  ServiceUtils.getProfUserd(pUser);
		Long savedId = pUserDao.saveProfessionalUser(profUserD);
		return savedId;

	}

	

	public ProfessionalUserRepository getRepos() {
		return repos;
	}



	public void setRepos(ProfessionalUserRepository repos) {
		this.repos = repos;
	}



	public ProfessionalUserDao getpUserDao() {
		return pUserDao;
	}



	public void setpUserDao(ProfessionalUserDao pUserDao) {
		this.pUserDao = pUserDao;
	}



	public UserVaultDao getUserVaultDao() {
		return userVaultDao;
	}



	public void setUserVaultDao(UserVaultDao userVaultDao) {
		this.userVaultDao = userVaultDao;
	}



	@Override
	public boolean isEmailIdAlreadyInUse(ProfessionalUser pUser) throws ServiceNestException {
		UserVault userVaultOptional = userVaultDao.findByEmailId(pUser.getEmailId());
		return userVaultOptional != null;
	}

	@Override
	public boolean isValidLogin(LoginUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long addAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<ProfessionalUser> getAllProfessionalUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProfessionalUser> getProfessionalUserById(Long professionalUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<ProfessionalUser> getProfessionalsByCity(String city) {
		
		List<ProfessionalUserD> prof = repos.findByServingCity(city);
		List<ProfessionalUser> list = new LinkedList<>();
		
		for(ProfessionalUserD p : prof) {
			list.add(ServiceUtils.getProfUser(p));
		}
		return list;
	}

	@Override
	public List<ProfessionalUser> getProfessionalsByServiceType(ServiceType type) {
		List<ProfessionalUserD> prof = repos.findByServiceType(type);
		
		List<ProfessionalUser> pusers = new LinkedList<>();
		
		for(ProfessionalUserD pd : prof) {
			
			ProfessionalUser p = ServiceUtils.getProfUser(pd);
			
			pusers.add(p);
		}
		return pusers;
	}

}
