package com.service.nest.domainI;

import java.util.List;

public interface JobService {

	public Long saveJob(Job job);

	public Job getServiceById(Long jobId);

	public List<String> getAllJobTypes();

	public List<Job> getAllJobsByType(JobType jobType);

}
