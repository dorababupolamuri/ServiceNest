package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.ProfessionalUserD;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.ProfessionalUserRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class ProfessionalUserDaoImplTest {
	


	@Mock
	private ProfessionalUserRepository professionalUserRepository;;

	@InjectMocks
	private ProfessionalUserDaoImpl professionalUserDaoImpl;

	@BeforeAll
	void setUp() {
		professionalUserRepository = Mockito.mock(ProfessionalUserRepository.class);
		professionalUserDaoImpl = new ProfessionalUserDaoImpl();

		professionalUserDaoImpl.setProfessionalUserRepository(professionalUserRepository);
	}

	@Test
	public void saveCart() throws ServiceNestException {
		ProfessionalUserD pUser = new ProfessionalUserD();
		Mockito.when(professionalUserRepository.save(Mockito.any())).thenReturn(pUser);

		Long addId = professionalUserDaoImpl.saveProfessionalUser(pUser);

		assertEquals(addId, pUser.getpUserId());

	}



}
