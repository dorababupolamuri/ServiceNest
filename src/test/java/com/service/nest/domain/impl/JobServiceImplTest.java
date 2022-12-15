package com.service.nest.domain.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.service.nest.dao.ServiceType;
import com.service.nest.dao.impl.ServiceDaoImpl;
import com.service.nest.domainI.Job;


@TestInstance(Lifecycle.PER_CLASS)
public class JobServiceImplTest {
	
	

	@Mock
	private ServiceDaoImpl serviceDao;
	

	@InjectMocks
	private JobServiceImpl JobeImpl;
	
	
	@BeforeAll
	void setUp() {
		serviceDao = Mockito.mock(ServiceDaoImpl.class);
		JobeImpl = new JobServiceImpl();
		JobeImpl.setServiceDao(serviceDao);
		
	}

	@Test
	public void saveJobTest() {

		Job job = new Job(12.22, "25.00", "wifi", 4.0, ServiceType.ELECTRICIANS);
		Mockito.when(serviceDao.saveService(Mockito.any())).thenReturn(Long.valueOf(1));
		Long id = JobeImpl.saveJob(job);
		assertEquals(id, Long.valueOf(1));
	}

}
