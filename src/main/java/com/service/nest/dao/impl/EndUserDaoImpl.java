package com.service.nest.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.EndUser;
import com.service.nest.dao.EndUserDao;
import com.service.nest.domainI.User;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.EndUserRepository;

@Component
public class EndUserDaoImpl implements EndUserDao {

	@Autowired
	private EndUserRepository endUserRepository;
	
	

	public EndUserRepository getEndUserRepository() {
		return endUserRepository;
	}

	public void setEndUserRepository(EndUserRepository endUserRepository) {
		this.endUserRepository = endUserRepository;
	}

	@Override
	public Long saveEndUser(EndUser endUser) throws ServiceNestException {

		EndUser endUserRes = endUserRepository.save(endUser);
		return endUserRes.getUserId();
	}

	@Override
	public List<User> getAllEndUsers() {
		return null;
	}

	@Override
	public Optional<User> getEnduserById(Long endUserId) {
		return null;
	}

	@Override
	public boolean isExist(Long endUserId) {
		return false;
	}

	@Override
	public void updateLoginStatus(boolean isActive, EndUser endUser) {

		endUser.setActive(isActive);
		endUserRepository.save(endUser);

	}

}
