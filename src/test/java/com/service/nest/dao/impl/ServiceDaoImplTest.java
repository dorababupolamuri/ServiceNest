package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.Service;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.ServiceRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class ServiceDaoImplTest {
	


	@Mock
	private ServiceRepository serviceRepository;

	@InjectMocks
	private ServiceDaoImpl serviceDaoImpl ;

	@BeforeAll
	void setUp() {
		serviceRepository = Mockito.mock(ServiceRepository.class);
		serviceDaoImpl = new ServiceDaoImpl();

		serviceDaoImpl.setServiceRepository(serviceRepository);
	}

	@Test
	public void saveCart() throws ServiceNestException {
		Service ser = new Service();
		Mockito.when(serviceRepository.save(Mockito.any())).thenReturn(ser);

		Long addId = serviceDaoImpl.saveService(ser);

		assertEquals(addId, ser.getServiceId());

	}



}

