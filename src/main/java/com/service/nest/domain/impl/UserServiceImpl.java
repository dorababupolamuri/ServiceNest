package com.service.nest.domain.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.nest.dao.Address;
import com.service.nest.dao.EndUser;
import com.service.nest.dao.EndUserDao;
import com.service.nest.dao.UserVault;
import com.service.nest.dao.UserVaultDao;
import com.service.nest.domainI.LoginUser;
import com.service.nest.domainI.User;
import com.service.nest.domainI.UserAddress;
import com.service.nest.domainI.UserService;
import com.service.nest.exception.ServiceNestException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EndUserDao endUserDao;

	@Autowired
	private UserVaultDao userVaultDao;
	
	

	// for junit mapping
	public EndUserDao getEndUserDao() {
		return endUserDao;
	}

	public void setEndUserDao(EndUserDao endUserDao) {
		this.endUserDao = endUserDao;
	}

	public UserVaultDao getUserVaultDao() {
		return userVaultDao;
	}

	public void setUserVaultDao(UserVaultDao userVaultDao) {
		this.userVaultDao = userVaultDao;
	}

	@Override
	public Long registerNewUser(User user) throws ServiceNestException {
		if (isEmailIdAlreadyInUse(user)) {
			throw new ServiceNestException("Email id already in use, please sign in or click forgot password.");
		}
		EndUser endUser = new EndUser();
		endUser.setMobileNumber(user.getMobileNumber());
		endUser.setName(user.getName());
		List<Address> address = getAddresses(user.getAddress(), endUser);
		endUser.setAddress(address);
		UserVault userVault = new UserVault();
		userVault.setEmailId(user.getEmailId());
		userVault.setPassword(user.getPassword());
		endUser.setUserVault(userVault);
		Long savedId = endUserDao.saveEndUser(endUser);
		return savedId;

	}

	private List<Address> getAddresses(List<UserAddress> userAdresses, EndUser endUser) {
		List<Address> addrList = new LinkedList<Address>();
		for (UserAddress userAddress : userAdresses) {

			Address add = new Address();
			add.setCity(userAddress.getCity());
			add.setStreetAddress(userAddress.getStreetAddress());
			add.setCountry(userAddress.getCountry());
			add.setPinCode(userAddress.getZipCode());
			add.setEndUser(endUser);
			addrList.add(add);

		}

		return addrList;
	}

	public boolean isEmailIdAlreadyInUse(User user) throws ServiceNestException {
		UserVault userVaultOptional = userVaultDao.findByEmailId(user.getEmailId());
		return userVaultOptional != null;
	}

	@Override
	public boolean isValidLogin(LoginUser user) {
		UserVault userVaultOptional = userVaultDao.findByEmailId(user.getEmailId());
		if (userVaultOptional != null) {
			if (user.getPassword().equals(userVaultOptional.getPassword())) {
				endUserDao.updateLoginStatus(true, userVaultOptional.getEndUser());
				return true;
			}
		}
		return false;
	}


	

}
