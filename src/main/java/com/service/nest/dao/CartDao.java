package com.service.nest.dao;

import java.util.List;
import java.util.Optional;

import com.service.nest.exception.ServiceNestException;

public interface CartDao {

	public Long saveCart(Cart cart) throws ServiceNestException;

	public List<Cart> getAllCartDetails();

	public List<Service> getSevicesByCartId(Long cartId);

	public Cart getCartByUserId(Long userId);
	
	public Optional<Cart> getCartByd(Long cartId);

}
