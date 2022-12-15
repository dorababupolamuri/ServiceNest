package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.Address;
import com.service.nest.repository.AddressRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class AddressDaoImplTest {

	@Mock
	private AddressRepository addressRepository;

	@InjectMocks
	private AddressDaoImpl addressDaoImpl;

	@BeforeAll
	void setUp() {
		addressRepository = Mockito.mock(AddressRepository.class);
		addressDaoImpl = new AddressDaoImpl();

		addressDaoImpl.setAddressRepository(addressRepository);
	}
	
	
	@Test
	public void saveAddressTest() {
		Address add = new Address();
		add.setId(1L);
		Mockito.when(addressRepository.save(Mockito.any())).thenReturn(add);
		
		
		Long addId = addressDaoImpl.saveAddress(add);
		
		assertEquals(addId, add.getId());
		
	}
	
	
	

}
