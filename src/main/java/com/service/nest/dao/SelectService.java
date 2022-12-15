package com.service.nest.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SelectService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long selectServiceId;

	private Long serviceId;

	private Integer count;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public SelectService() {
	}

	public SelectService(Long serviceId, Integer count, Cart cart) {
		this.serviceId = serviceId;
		this.count = count;
		this.cart = cart;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}