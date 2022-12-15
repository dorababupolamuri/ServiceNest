package com.service.nest.domainI;

import java.util.Map;

public class JobDetails {

	private String emailId;

	private Map<String, Integer> userServiceCountMap;

	public JobDetails() {
	}

	public JobDetails(String emailId, Map<String, Integer> userServiceCountMap) {
		this.emailId = emailId;
		this.userServiceCountMap = userServiceCountMap;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Map<String, Integer> getUserServiceCountMap() {
		return userServiceCountMap;
	}

	public void setUserServiceCountMap(Map<String, Integer> userServiceCountMap) {
		this.userServiceCountMap = userServiceCountMap;
	}

}