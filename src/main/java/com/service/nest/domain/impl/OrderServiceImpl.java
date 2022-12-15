package com.service.nest.domain.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.nest.dao.Address;
import com.service.nest.dao.AddressDao;
import com.service.nest.dao.OrderDetails;
import com.service.nest.dao.OrderDetailsDao;
import com.service.nest.dao.ProfessionalUserD;
import com.service.nest.dao.ServiceCost;
import com.service.nest.dao.ServiceDao;
import com.service.nest.domainI.CartDetails;
import com.service.nest.domainI.CartService;
import com.service.nest.domainI.OrderService;
import com.service.nest.domainI.PriceDetails;
import com.service.nest.domainI.ProfessionalUser;
import com.service.nest.domainI.ProfessionalUserService;
import com.service.nest.exception.ServiceNestException;
import com.service.nest.util.ServiceUtils;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartService CartService;

	@Autowired
	private ProfessionalUserService pUserService;

	@Autowired
	private ServiceDao serviceDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private OrderDetailsDao orderDao;
	
	//for junit testing
	public CartService getCartService() {
		return CartService;
	}

	public void setCartService(CartService cartService) {
		CartService = cartService;
	}

	public ProfessionalUserService getpUserService() {
		return pUserService;
	}

	public void setpUserService(ProfessionalUserService pUserService) {
		this.pUserService = pUserService;
	}

	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public OrderDetailsDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDetailsDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Long bookService(Long cartId, Long addressId) throws ServiceNestException {

		CartDetails cartDetails = CartService.viewCart(cartId);
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setAddressId(addressId);

		List<ServiceCost> services = new LinkedList<ServiceCost>();
		orderDetails.setGrandTotal(cartDetails.getGrandTotal());
		orderDetails.setTaxes(cartDetails.getTaxes());

		List<ProfessionalUserD> assignedProfessional = new LinkedList<ProfessionalUserD>();

		List<PriceDetails> priceDetails = cartDetails.getServiceCost();
		for (PriceDetails priceDetail : priceDetails) {
			ServiceCost sCost = new ServiceCost();
			sCost.setCount(priceDetail.getCount());
			sCost.setDuration(priceDetail.getDuration());
			sCost.setFare(priceDetail.getUnitFare());
			sCost.setFare(priceDetail.getFare());
			sCost.setServiceName(priceDetail.getServiceName());

			sCost.setOrderDtls(orderDetails);
			services.add(sCost);
			com.service.nest.dao.Service sr = serviceDao.getServiceByName(priceDetail.getServiceName());
			List<ProfessionalUser> proUsers = pUserService.getProfessionalsByServiceType(sr.getServiceType());

			ProfessionalUser proUser = getProfessionalForService(proUsers, addressId);
			ProfessionalUserD pd = ServiceUtils.getProfUserd(proUser);
			assignedProfessional.add(pd);
		}

		orderDetails.setServiceCost(services);
		orderDetails.setAssignedProfessional(assignedProfessional);

		orderDetails.setAssignedProfessional(assignedProfessional);

		Long id = orderDao.saveNewOrder(orderDetails);

		return id;
	}

	private ProfessionalUser getProfessionalForService(List<ProfessionalUser> proUsers, Long addressId) {

		Optional<Address> add = addressDao.getAddressById(addressId);
		String city = null;

		if (add.isPresent()) {
			city = add.get().getCity();

		}

		for (ProfessionalUser pu : proUsers) {
			if (pu.getServingCity().equals(city) && pu.isAvailable()) {
				return pu;
			}
		}
		return null;
	}

}
