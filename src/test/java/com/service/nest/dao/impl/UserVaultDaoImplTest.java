package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.UserVault;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.UserVaultRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class UserVaultDaoImplTest {
	


	@Mock
	private UserVaultRepository userVaultRepository;

	@InjectMocks
	private UserVaultDaoImpl userVaultDaoImpl;

	@BeforeAll
	void setUp() {
		userVaultRepository = Mockito.mock(UserVaultRepository.class);
		userVaultDaoImpl = new UserVaultDaoImpl();

		userVaultDaoImpl.setUserVaultRepository(userVaultRepository);
	}

	@Test
	public void saveCart() throws ServiceNestException {
		UserVault vault  =  new UserVault();
		Mockito.when(userVaultRepository.save(Mockito.any())).thenReturn(vault);

		Long addId = userVaultDaoImpl.saveUserVault(vault);

		assertEquals(addId, vault.getId());

	}



}