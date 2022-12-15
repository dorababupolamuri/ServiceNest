package com.service.nest.dao;

import java.util.List;
import java.util.Optional;

import com.service.nest.domainI.User;
import com.service.nest.exception.ServiceNestException;

public interface EndUserDao {
	public Long saveEndUser(EndUser user) throws ServiceNestException;

	public List<User> getAllEndUsers();

	public Optional<User> getEnduserById(Long endUserId);

	public boolean isExist(Long endUserId);
	
	public void updateLoginStatus(boolean isActive, EndUser endUser);
	
}
