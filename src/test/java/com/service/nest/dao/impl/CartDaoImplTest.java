package com.service.nest.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.Cart;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.CartRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class CartDaoImplTest {

	@Mock
	private CartRepository cartRepository;

	@InjectMocks
	private CartDaoImpl cartDaoImpl;

	@BeforeAll
	void setUp() {
		cartRepository = Mockito.mock(CartRepository.class);
		cartDaoImpl = new CartDaoImpl();

		cartDaoImpl.setCartRepository(cartRepository);
	}

	@Test
	public void saveCart() throws ServiceNestException {
		Cart crt = new Cart();
		Mockito.when(cartRepository.save(Mockito.any())).thenReturn(crt);

		Long addId = cartDaoImpl.saveCart(crt);

		assertEquals(addId, crt.getUserId());

	}

}
