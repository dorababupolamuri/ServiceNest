package com.service.nest.domain.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.nest.dao.ServiceDao;
import com.service.nest.dao.ServiceType;
import com.service.nest.domainI.Job;
import com.service.nest.domainI.JobService;
import com.service.nest.domainI.JobType;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private ServiceDao serviceDao;
	
	
	
	// for junit testing
	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public Long saveJob(Job job) {

		com.service.nest.dao.Service service = new com.service.nest.dao.Service();
		service.setServiceCost(job.getBasePrice());
		service.setServiceDuration(job.getTimeRequired());
		service.setServiceName(job.getName());
		service.setServiceType(job.getType());
		service.setServiceRating(job.getRating());
		return serviceDao.saveService(service);
	}

	@Override
	public Job getServiceById(Long jobId) {

		return null;
	}

	@Override
	public List<String> getAllJobTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getAllJobsByType(JobType jobType) {
		List<com.service.nest.dao.Service> services = serviceDao
				.getAllServicesByType(ServiceType.getServiceType(jobType.name()));

		List<Job> jobs = new LinkedList<>();

		for (com.service.nest.dao.Service service : services) {
			Job job = new Job();
			job.setBasePrice(service.getServiceCost());
			job.setName(service.getServiceName());
			job.setRating(service.getServiceRating());
			job.setTimeRequired(service.getServiceDuration());
			job.setType(service.getServiceType());
			jobs.add(job);

		}
		return jobs;
	}

}
