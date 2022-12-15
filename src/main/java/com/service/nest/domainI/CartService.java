package com.service.nest.domainI;

import com.service.nest.exception.ServiceNestException;

public interface CartService {

	public Long addToCart(JobDetails jobDetails) throws ServiceNestException;

	public CartDetails viewCart(Long cartId) throws ServiceNestException;

}
