package com.service.nest.domain.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.Address;
import com.service.nest.dao.Service;
import com.service.nest.dao.ServiceType;
import com.service.nest.dao.impl.AddressDaoImpl;
import com.service.nest.dao.impl.OrderDetailsDaoImpl;
import com.service.nest.dao.impl.ServiceDaoImpl;
import com.service.nest.domainI.CartDetails;
import com.service.nest.domainI.PriceDetails;
import com.service.nest.domainI.ProfessionalUser;
import com.service.nest.domainI.UserAddress;
import com.service.nest.exception.ServiceNestException;

@TestInstance(Lifecycle.PER_CLASS)
public class OrderServiceImplTest {

	@Mock
	private CartServiceImpl cartService;

	@Mock
	private ProfessionalUserServiceImpl pUserService;

	@Mock
	private ServiceDaoImpl serviceDao;

	@Mock
	private AddressDaoImpl addressDao;

	@Mock
	private OrderDetailsDaoImpl orderDao;

	@InjectMocks
	private OrderServiceImpl orderServiceImpl;

	@BeforeAll
	void setUp() {
		cartService = Mockito.mock(CartServiceImpl.class);
		pUserService = Mockito.mock(ProfessionalUserServiceImpl.class);
		serviceDao = Mockito.mock(ServiceDaoImpl.class);
		addressDao = Mockito.mock(AddressDaoImpl.class);
		orderDao = Mockito.mock(OrderDetailsDaoImpl.class);

		orderServiceImpl = new OrderServiceImpl();

		orderServiceImpl.setCartService(cartService);
		orderServiceImpl.setpUserService(pUserService);
		orderServiceImpl.setServiceDao(serviceDao);
		orderServiceImpl.setAddressDao(addressDao);
		orderServiceImpl.setOrderDao(orderDao);

	}

	@Test
	public void bookServiceTest() throws ServiceNestException {

		CartDetails cartDetails = new CartDetails();
		cartDetails.setGrandTotal(136.25);
		cartDetails.setTaxes(12.25);
		List<PriceDetails> priceDetails = new ArrayList<>();
		PriceDetails priceDetail = new PriceDetails();
		priceDetail.setCount(2);
		priceDetail.setDuration("25");
		priceDetail.setFare(25.36);
		priceDetail.setServiceName("Wifi Installation");
		priceDetail.setUnitFare(12.18);

		priceDetails.add(priceDetail);

		cartDetails.setServiceCost(priceDetails);

		com.service.nest.dao.Service serv = new Service();
		serv.setServiceCost(25.00);
		serv.setServiceDuration("25");
		serv.setServiceId(1L);
		serv.setServiceName("Wifi Installation");
		serv.setServiceRating(4.0);
		serv.setServiceType(ServiceType.ELECTRICIANS);
		
		Address add = new Address("dhgd", "syracuse", "USA", 13210, null);
	   Optional<Address> opt = Optional.of(add);
	    

		List<ProfessionalUser> proUsers = new ArrayList<>();
		

		List<UserAddress> userAddress = new ArrayList<>();
		UserAddress us = new UserAddress("agyag", "syracuse", "USA", 13210, null);
		userAddress.add(us);

		ProfessionalUser proUser = new ProfessionalUser("Mi", 9876543210L, "d@gmail.com", "me@123", userAddress,
				"Electricals", "home decors", "SS1", true, 2.5, 4.2, "syracuse", ServiceType.ELECTRICIANS);
		proUsers.add(proUser);

		Mockito.when(cartService.viewCart(Mockito.anyLong())).thenReturn(cartDetails);
		Mockito.when(serviceDao.getServiceByName("Wifi Installation")).thenReturn(serv);
		Mockito.when(pUserService.getProfessionalsByServiceType(serv.getServiceType())).thenReturn(proUsers);
		Mockito.when(addressDao.getAddressById(Mockito.anyLong())).thenReturn(opt);
		
		Mockito.when(orderDao.saveNewOrder(Mockito.any())).thenReturn(1L);

		Long id = orderServiceImpl.bookService(1L, 1L);

		assertEquals(id, Long.valueOf(1));

	}

}
