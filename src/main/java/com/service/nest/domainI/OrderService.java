package com.service.nest.domainI;

import com.service.nest.exception.ServiceNestException;

public interface OrderService {
	
	public Long bookService(Long cartId, Long addressId) throws ServiceNestException;
	
	

}
