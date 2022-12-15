package com.service.nest.domain.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.UserVault;
import com.service.nest.dao.impl.EndUserDaoImpl;
import com.service.nest.dao.impl.UserVaultDaoImpl;
import com.service.nest.domainI.LoginUser;
import com.service.nest.domainI.User;
import com.service.nest.domainI.UserAddress;
import com.service.nest.exception.ServiceNestException;

@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceImplTest {

	

	@Mock
	private EndUserDaoImpl endUserDao;
	

	@Mock
	private UserVaultDaoImpl userVaultDao;

	@InjectMocks
	private UserServiceImpl userImpl;

	
	
	@BeforeAll
	void setUp() {
		userVaultDao = Mockito.mock(UserVaultDaoImpl.class);
		endUserDao = Mockito.mock(EndUserDaoImpl.class);
		userImpl = new UserServiceImpl();
		userImpl.setEndUserDao(endUserDao);
		userImpl.setUserVaultDao(userVaultDao);
		
		
	}


	@Test
	public void isEmailIdAlreadyInUseTest() throws ServiceNestException {
		UserVault vault = new UserVault();
		User user = new User();
		user.setEmailId("neja@gmail.com");
		Mockito.when(userVaultDao.findByEmailId(Mockito.anyString())).thenReturn(vault);
		boolean result = userImpl.isEmailIdAlreadyInUse(user);
		assertEquals(result, true);
	}

	@Test
	public void registerNewUserTest() throws ServiceNestException {
		List<UserAddress> addList = new ArrayList<>();
		User user = new User("hgsy", 1234567890L, "sgygsygs", "dhgdhu", addList);

		
		Mockito.when(userVaultDao.findByEmailId(Mockito.anyString())).thenReturn(null);
		Mockito.when(endUserDao.saveEndUser(Mockito.any())).thenReturn(1L);
		Long id = userImpl.registerNewUser(user);
		Assertions.assertTrue(id != null);
	}

	@Test
	public void isValidLoginTest() {


		UserVault uv = new UserVault();

		uv.setEmailId("test@gmail.com");
		uv.setPassword("123");

		LoginUser user = new LoginUser();
		user.setEmailId("test@gmail.com");
		user.setPassword("123");

		Mockito.when(userVaultDao.findByEmailId(Mockito.any())).thenReturn(uv);

		doNothing().when(endUserDao).updateLoginStatus(Mockito.anyBoolean(), Mockito.any());

		boolean result = userImpl.isValidLogin(user);

		Assertions.assertTrue(result);

	}

}
