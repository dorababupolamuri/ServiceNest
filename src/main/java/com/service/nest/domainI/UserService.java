package com.service.nest.domainI;

import com.service.nest.exception.ServiceNestException;

public interface UserService {

	public Long registerNewUser(User user) throws ServiceNestException;
	
	public boolean isEmailIdAlreadyInUse(User user) throws ServiceNestException;

	public boolean isValidLogin(LoginUser user);


}
