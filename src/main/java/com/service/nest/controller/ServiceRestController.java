package com.service.nest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.nest.dao.ServiceType;
import com.service.nest.domainI.Job;
import com.service.nest.domainI.JobService;
import com.service.nest.domainI.JobType;

@RestController
@RequestMapping("/serviceNest/service")
public class ServiceRestController {

	@Autowired
	private JobService jobService;

	@PostMapping("/create")
	public ResponseEntity<String> saveService(@RequestBody Job job) {
		ResponseEntity<String> resp = null;
		try {
			Long id = jobService.saveJob(job);
			resp = new ResponseEntity<String>("saved with:" + id, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllServices() {

		ResponseEntity<?> resp = null;
		try {
			List<String> list = jobService.getAllJobTypes();
			if (list == null || list.isEmpty()) {
				resp = new ResponseEntity<String>("NO DATA FOUND", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<String>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

//	@GetMapping("/byType")
//	public ResponseEntity<?> getServiceById(@RequestParam String type) {
//		ResponseEntity<?> resp = null;
//		Optional<Service> optional = jobService.getAllJobsByType(type);
//		if (optional.isPresent()) {
//			resp = new ResponseEntity<Service>(optional.get(), HttpStatus.OK);
//		} else {
//			resp = new ResponseEntity<String>(serviceId + "Data Not Found ", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}

//	@PutMapping("/modify")
//	public ResponseEntity<String> updateServiceById(@RequestBody Job job) {
//		ResponseEntity<String> resp = null;
//		Optional<Service> id = jobService.getServiceById(job.getServiceId());
//		boolean exist = id.isPresent();
//		if (exist) {
//			iService.saveService(service);
//			resp = new ResponseEntity<String>("Updated SuccessFully", HttpStatus.OK);
//		} else {
//			resp = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}

	@GetMapping("/showAllServiceTypes")
	public ResponseEntity<?> getAllServiceTypes() {

		ResponseEntity<?> resp = null;
		try {
			List<String> list = jobService.getAllJobTypes();
			if (list == null || list.isEmpty()) {
				resp = new ResponseEntity<String>("NO DATA FOUND", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<String>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

	@GetMapping("/allServicesByType")
	public ResponseEntity<?> getAllServicesByServiceType(@RequestParam String serviceId) {

		ResponseEntity<?> resp = null;
		try {
			ServiceType serviceType = ServiceType.getServiceType(serviceId);

			if (serviceType == null) {
				resp = new ResponseEntity<String>("Invalid Service Id", HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}
			List<Job> list = jobService.getAllJobsByType(JobType.getJobType(serviceId));
			if (list == null || list.isEmpty()) {
				resp = new ResponseEntity<String>("NO DATA FOUND", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Job>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

}
