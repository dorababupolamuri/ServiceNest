package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.EndUser;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.EndUserRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class EndUserDaoImplTest {
	


	@Mock
	private EndUserRepository endUserRepository;

	@InjectMocks
	private EndUserDaoImpl endUserDaoImpl;

	@BeforeAll
	void setUp() {
		endUserRepository = Mockito.mock(EndUserRepository.class);
		endUserDaoImpl = new EndUserDaoImpl();

		endUserDaoImpl.setEndUserRepository(endUserRepository);
	}

	@Test
	public void saveCart() throws ServiceNestException {
		EndUser endUs = new EndUser();
		Mockito.when(endUserRepository.save(Mockito.any())).thenReturn(endUs);

		Long addId = endUserDaoImpl.saveEndUser(endUs);

		assertEquals(addId, endUs.getUserId());

	}



}
