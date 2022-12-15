package com.service.nest.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.Cart;
import com.service.nest.dao.CartDao;
import com.service.nest.dao.Service;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.repository.CartRepository;

@Component
public class CartDaoImpl implements CartDao {

	@Autowired
	private CartRepository cartRepository;
	
	

	public CartRepository getCartRepository() {
		return cartRepository;
	}

	public void setCartRepository(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public Long saveCart(Cart cart) throws ServiceNestException {

		Cart crt =  cartRepository.save(cart);
		return crt.getCartId();
	}

	@Override
	public List<Cart> getAllCartDetails() {
		return cartRepository.findAll();

	}

	@Override
	public List<Service> getSevicesByCartId(Long cartId) {
		List<Service> services = cartRepository.findByCartId(cartId);
		return services;
	}

	@Override
	public Cart getCartByUserId(Long userId) {
		Cart ct = cartRepository.findByUserId(userId);
		return ct;
	}

	@Override
	public Optional<Cart> getCartByd(Long cartId) {
		Optional<Cart> ctOptional = cartRepository.findById(cartId);
		return ctOptional;
	}

	

}
