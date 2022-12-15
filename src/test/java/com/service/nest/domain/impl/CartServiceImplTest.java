package com.service.nest.domain.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.Cart;
import com.service.nest.dao.EndUser;
import com.service.nest.dao.SelectService;
import com.service.nest.dao.Service;
import com.service.nest.dao.ServiceType;
import com.service.nest.dao.UserVault;
import com.service.nest.dao.impl.CartDaoImpl;
import com.service.nest.dao.impl.EndUserDaoImpl;
import com.service.nest.dao.impl.ServiceDaoImpl;
import com.service.nest.dao.impl.UserVaultDaoImpl;
import com.service.nest.domainI.JobDetails;
import com.service.nest.domainI.User;
import com.service.nest.exception.ServiceNestException;


@TestInstance(Lifecycle.PER_CLASS)
public class CartServiceImplTest {
	
	
	
	@Mock
	private CartDaoImpl cartDao;

	@Mock
	private UserVaultDaoImpl userVaultDao;

	@Mock
	private EndUserDaoImpl endUserDao;

	@Mock
	private ServiceDaoImpl serviceeDao;
	
	@InjectMocks
	private CartServiceImpl cartServiceImpl;
	
	
	
	@BeforeAll
	void setUp() {
		cartDao = Mockito.mock(CartDaoImpl.class);
		userVaultDao = Mockito.mock(UserVaultDaoImpl.class);
		endUserDao = Mockito.mock(EndUserDaoImpl.class);
		serviceeDao = Mockito.mock(ServiceDaoImpl.class);
		
		cartServiceImpl = new CartServiceImpl();
		
		cartServiceImpl.setEndUserDao(endUserDao);
		cartServiceImpl.setUserVaultDao(userVaultDao);
		cartServiceImpl.setServiceeDao(serviceeDao);
		cartServiceImpl.setCartDao(cartDao);
		
		
	}
	
	
	@Test
	public void addToCartTest() throws ServiceNestException {
		UserVault vault = new UserVault();
		User user = new User();
		user.setEmailId("neja@gmail.com");
		
		EndUser endUser = new EndUser();
		endUser.setUserId(1L);
		vault.setEndUser(endUser);
		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setEmailId("hm@gmail.com");
		Map<String, Integer> map = new HashMap<>();
		map.put("Wifi InstallatWifiion", 2);
		jobDetails.setUserServiceCountMap(map );
		
		Cart cart = new Cart();
		cart.setUserId(1L);
		List<SelectService> servs = new ArrayList<>();
		cart.setUserServices(servs);
		
		com.service.nest.dao.Service  serv = new Service();
		serv.setServiceCost(25.00);
		serv.setServiceDuration("25");
		serv.setServiceId(1L);
		serv.setServiceName("Wifi Installation");
		serv.setServiceRating(4.0);
		serv.setServiceType(ServiceType.ELECTRICIANS);
		
		
		Mockito.when(userVaultDao.findByEmailId("hm@gmail.com")).thenReturn(vault);
		Mockito.when(cartDao.getCartByUserId(1L)).thenReturn(cart);
		Mockito.when(serviceeDao.getServiceByName("Wifi InstallatWifiion")).thenReturn(serv);
		Mockito.when(cartDao.saveCart(cart)).thenReturn(1L);
		
		
		
		
		
		Long id = cartServiceImpl.addToCart(jobDetails);
		
		assertEquals(id, Long.valueOf(1));
		
	}

}
