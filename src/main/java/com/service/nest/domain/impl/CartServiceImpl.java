package com.service.nest.domain.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.nest.dao.Cart;
import com.service.nest.dao.CartDao;
import com.service.nest.dao.EndUser;
import com.service.nest.dao.EndUserDao;
import com.service.nest.dao.SelectService;
import com.service.nest.dao.ServiceDao;
import com.service.nest.dao.UserVault;
import com.service.nest.dao.UserVaultDao;
import com.service.nest.domainI.CartDetails;
import com.service.nest.domainI.CartService;
import com.service.nest.domainI.JobDetails;
import com.service.nest.domainI.PriceDetails;
import com.service.nest.exception.ServiceNestException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private UserVaultDao userVaultDao;

	@Autowired
	private EndUserDao endUserDao;

	@Autowired
	private ServiceDao serviceeDao;
	
	
	// for junit testing
	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public UserVaultDao getUserVaultDao() {
		return userVaultDao;
	}

	public void setUserVaultDao(UserVaultDao userVaultDao) {
		this.userVaultDao = userVaultDao;
	}

	public EndUserDao getEndUserDao() {
		return endUserDao;
	}

	public void setEndUserDao(EndUserDao endUserDao) {
		this.endUserDao = endUserDao;
	}

	public ServiceDao getServiceeDao() {
		return serviceeDao;
	}

	public void setServiceeDao(ServiceDao serviceeDao) {
		this.serviceeDao = serviceeDao;
	}

	@Override
	public Long addToCart(JobDetails jobDetails) throws ServiceNestException {

		UserVault userVault = userVaultDao.findByEmailId(jobDetails.getEmailId());
		if (userVault == null) {
			throw new ServiceNestException("unable to add to cart");
		}
		EndUser user = userVault.getEndUser();
		if (user == null) {
			throw new ServiceNestException("unable to add to cart");
		}

		// update flow:
		Cart cart = cartDao.getCartByUserId(user.getUserId());
		if (cart != null) {
			cart.getUserServices().addAll(getServicesFromIds(jobDetails, cart));
			Long id = cartDao.saveCart(cart);
			return id;
		}
		// insert flow
		cart = new Cart();
		cart.setUserId(user.getUserId());
		cart.setUserServices(getServicesFromIds(jobDetails, cart));
		Long id = cartDao.saveCart(cart);
		return id;
	}

	private List<SelectService> getServicesFromIds(JobDetails jobDetails, Cart cart) throws ServiceNestException {

		List<SelectService> servicesSelected = new LinkedList<SelectService>();
		Map<String, Integer> serviceCount = jobDetails.getUserServiceCountMap();
		for (Map.Entry<String, Integer> entry : serviceCount.entrySet()) {
			com.service.nest.dao.Service service = serviceeDao.getServiceByName(entry.getKey());
			if (service == null) {
				throw new ServiceNestException("unable to add to cart, please try after some time");
			}
			SelectService selectServ = new SelectService();
			selectServ.setServiceId(service.getServiceId());
			selectServ.setCount(entry.getValue());
			selectServ.setCart(cart);
			servicesSelected.add(selectServ);

		}
		return servicesSelected;
	}

	@Override
	public CartDetails viewCart(Long cartId) throws ServiceNestException {

		CartDetails cartDetails = new CartDetails();
		List<PriceDetails> priceDetails = new LinkedList<PriceDetails>();
		Optional<Cart> cartOptional = cartDao.getCartByd(cartId);
		if (cartOptional.isEmpty()) {
			throw new ServiceNestException("gsyg");
		}

		Double totalServicesCost = 0.0;
		Double taxes = 0.0;
		Cart existingCart = cartOptional.get();
		List<SelectService> servicesSelected = existingCart.getUserServices();
		for (SelectService selectService : servicesSelected) {
			Long serviceId = selectService.getServiceId();
			Optional<com.service.nest.dao.Service> serviceOptional = serviceeDao.getServiceById(serviceId);
			if (serviceOptional.isPresent()) {
				PriceDetails sCost = new PriceDetails();
				com.service.nest.dao.Service service = serviceOptional.get();
				sCost.setServiceName(service.getServiceName());
				sCost.setDuration(service.getServiceDuration());
				sCost.setUnitFare(service.getServiceCost());
				sCost.setCount(selectService.getCount());
				Double toalCostPerService = selectService.getCount() * service.getServiceCost();
				sCost.setFare(toalCostPerService);
				totalServicesCost += toalCostPerService;
				priceDetails.add(sCost);
			}
		}
		cartDetails.setServiceCost(priceDetails);
		taxes = totalServicesCost * (0.18);
		cartDetails.setTaxes(taxes);
		cartDetails.setGrandTotal(totalServicesCost + taxes);
		return cartDetails;
	}

}
