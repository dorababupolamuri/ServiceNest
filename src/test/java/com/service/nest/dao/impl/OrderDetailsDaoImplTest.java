package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.OrderDetails;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.OrderDetailsRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class OrderDetailsDaoImplTest {
	


	@Mock
	private OrderDetailsRepository otrDetailsRepository;

	@InjectMocks
	private OrderDetailsDaoImpl orderDetailsDaoImpl;

	@BeforeAll
	void setUp() {
		otrDetailsRepository = Mockito.mock(OrderDetailsRepository.class);
		orderDetailsDaoImpl = new OrderDetailsDaoImpl();

		orderDetailsDaoImpl.setRepo(otrDetailsRepository);
	}

	@Test
	public void saveCart() throws ServiceNestException {
		OrderDetails ord = new OrderDetails();
		Mockito.when(otrDetailsRepository.save(Mockito.any())).thenReturn(ord);

		Long addId = orderDetailsDaoImpl.saveNewOrder(ord);

		assertEquals(addId, ord.getOrderId());

	}



}
