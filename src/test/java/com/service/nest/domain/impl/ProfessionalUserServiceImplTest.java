package com.service.nest.domain.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.ProfessionalUserDao;
import com.service.nest.dao.ServiceType;
import com.service.nest.dao.UserVault;
import com.service.nest.dao.UserVaultDao;
import com.service.nest.domainI.ProfessionalUser;
import com.service.nest.domainI.UserAddress;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.ProfessionalUserRepository;


@TestInstance(Lifecycle.PER_CLASS)
public class ProfessionalUserServiceImplTest {
	
	@Mock
	private ProfessionalUserRepository repos;

	@Mock
	private ProfessionalUserDao pUserDao;

	@Mock
	private UserVaultDao userVaultDao;
	
	
	
	@InjectMocks
	private ProfessionalUserServiceImpl professionalUserServiceImpl;

	@BeforeAll
	void setUp() {
		repos = Mockito.mock(ProfessionalUserRepository.class);
		pUserDao = Mockito.mock(ProfessionalUserDao.class);
		userVaultDao = Mockito.mock(UserVaultDao.class);
		

		professionalUserServiceImpl = new ProfessionalUserServiceImpl();

		professionalUserServiceImpl.setpUserDao(pUserDao);
		professionalUserServiceImpl.setRepos(repos);
		professionalUserServiceImpl.setUserVaultDao(userVaultDao);

	}
	
	
	@Test
	public void isEmailIdAlreadyInUseTest() throws ServiceNestException {
		
		UserVault vault = new UserVault();
		ProfessionalUser user = new ProfessionalUser();
		user.setEmailId("neja@gmail.com");
		Mockito.when(userVaultDao.findByEmailId(Mockito.anyString())).thenReturn(vault);
		boolean result = professionalUserServiceImpl.isEmailIdAlreadyInUse(user);
		assertEquals(result, true);
	}
	
	@Test
	public void registerNewProfessionalUserTest() throws ServiceNestException {
		
		Mockito.when(userVaultDao.findByEmailId(Mockito.anyString())).thenReturn(null);
		
		
		List<UserAddress> userAddress = new ArrayList<>();
		UserAddress us = new UserAddress("agyag", "syracuse", "USA", 13210, null);
		userAddress.add(us);
		ProfessionalUser proUser = new ProfessionalUser("Mi", 9876543210L, "d@gmail.com", "me@123", userAddress,
				"Electricals", "home decors", "SS1", true, 2.5, 4.2, "syracuse", ServiceType.ELECTRICIANS);

		Mockito.when(pUserDao.saveProfessionalUser(Mockito.any())).thenReturn(1L);
		Long id = professionalUserServiceImpl.registerNewProfessionalUser(proUser);
		Assertions.assertTrue(id != null);
	}


	

}
