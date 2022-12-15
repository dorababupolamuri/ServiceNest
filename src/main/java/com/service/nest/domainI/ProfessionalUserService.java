package com.service.nest.domainI;

import java.util.List;
import java.util.Optional;

import com.service.nest.dao.Address;
import com.service.nest.dao.ServiceType;
import com.service.nest.exception.ServiceNestException;

public interface ProfessionalUserService {
	

	public Long registerNewProfessionalUser(ProfessionalUser pUser) throws ServiceNestException;
	
	public boolean isEmailIdAlreadyInUse(ProfessionalUser pUser) throws ServiceNestException;

	public boolean isValidLogin(LoginUser user);

	public Long addAddress(Address address);
	
	public List<ProfessionalUser> getProfessionalsByCity(String city);
	
	public List<ProfessionalUser> getProfessionalsByServiceType(ServiceType type); 

	public List<ProfessionalUser> getAllProfessionalUsers();

	public Optional<ProfessionalUser> getProfessionalUserById(Long professionalUserId);
	
	
	


}
