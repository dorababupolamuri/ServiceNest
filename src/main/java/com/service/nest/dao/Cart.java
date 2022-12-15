package com.service.nest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id", nullable = false)
	private Long cartId;

	private Long userId;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<SelectService> userServices = new ArrayList<SelectService>();

	public Cart() {
	}

	public Cart(Long userId, List<SelectService> userServices) {
		this.userId = userId;
		this.userServices = userServices;
	}

	public Long getCartId() {
		return cartId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<SelectService> getUserServices() {
		return userServices;
	}

	public void setUserServices(List<SelectService> userServices) {
		this.userServices = userServices;
	}

}
