package com.service.nest.domainI;

public enum JobType {

	SALON_FOR_MEN("1"), SALON_FOR_WOMEN("2"), APPLIANCE_REPAIR("3"), CLEANING_AND_PEST_CONTROL("4"), ELECTRICIANS("5"),
	CARPENTERS("6"), PLUMBERS("7");

	private String jobId;

	JobType(String jobId) {
		this.jobId = jobId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setServiceId(String jobId) {
		this.jobId = jobId;
	}

	public static JobType getJobType(String jobId) {
		for (JobType serv : JobType.values()) {
			if (serv.getJobId().equals(jobId)) {
				return serv;
			}
		}
		return null;
	}

}
