package com.service.nest.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.UserVaultDao;
import com.service.nest.dao.UserVault;
import com.service.nest.repository.UserVaultRepository;

@Component
public class UserVaultDaoImpl implements UserVaultDao {

	@Autowired
	private UserVaultRepository userVaultRepository;
	
	

	public UserVaultRepository getUserVaultRepository() {
		return userVaultRepository;
	}

	public void setUserVaultRepository(UserVaultRepository userVaultRepository) {
		this.userVaultRepository = userVaultRepository;
	}

	@Override
	public Long saveUserVault(UserVault userVault) {
		UserVault userVaultResp = userVaultRepository.save(userVault);
		return userVaultResp.getId();

	}

	@Override
	public Optional<UserVault> getEnduserById(Long userVaultId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVault findByEmailId(String emailId) {
		UserVault user = userVaultRepository.findByEmailId(emailId);
		return user;
	}

}
