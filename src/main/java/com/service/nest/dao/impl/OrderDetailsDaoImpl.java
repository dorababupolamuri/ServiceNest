package com.service.nest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.nest.dao.OrderDetails;
import com.service.nest.dao.OrderDetailsDao;
import com.service.nest.repository.OrderDetailsRepository;


@Component
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	
	@Autowired
	private OrderDetailsRepository repo;
	
	

	public OrderDetailsRepository getRepo() {
		return repo;
	}



	public void setRepo(OrderDetailsRepository repo) {
		this.repo = repo;
	}



	@Override
	public Long saveNewOrder(OrderDetails oderDetails) {
		OrderDetails oDetails =  repo.save(oderDetails);
		
		return oDetails.getOrderId();
	}

}
