package com.service.nest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.nest.domainI.ProfessionalUser;
import com.service.nest.domainI.ProfessionalUserService;

@RestController
@RequestMapping("/serviceNest/professionalUser")
public class ProfessionalUserRestController {

	@Autowired
	private ProfessionalUserService service;

	@PostMapping("/create")
	public ResponseEntity<String> saveProfessionalUser(@RequestBody ProfessionalUser professionalUser) {
		ResponseEntity<String> resp = null;
		try {
			Long id = service.registerNewProfessionalUser(professionalUser);
			resp = new ResponseEntity<String>("saved with:" + id, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllProfessionalUsers() {

		ResponseEntity<?> resp = null;
		try {
			List<ProfessionalUser> list = service.getAllProfessionalUsers();
			if (list == null || list.isEmpty()) {
				resp = new ResponseEntity<String>("NO DATA FOUND", HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<ProfessionalUser>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	@GetMapping("/byId")
	public ResponseEntity<?> getUserById(@RequestParam Long professionalUserId) {
		ResponseEntity<?> resp = null;
		Optional<ProfessionalUser> optional = service.getProfessionalUserById(professionalUserId);
		if (optional.isPresent()) {
			resp = new ResponseEntity<ProfessionalUser>(optional.get(), HttpStatus.OK);
		} else {
			resp = new ResponseEntity<String>(professionalUserId + "Data Not Found ", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	/*
	 * @PutMapping("/modify") public ResponseEntity<String>
	 * updateProfessionalUser(@RequestBody ProfessionalUser professionalUser) {
	 * ResponseEntity<String> resp = null; Long id = professionalUser.getUserId();
	 * boolean exist = service.isExist(id); if (exist) {
	 * service.registerNewProfessionalUser(professionalUser); resp = new
	 * ResponseEntity<String>("Updated SuccessFully", HttpStatus.OK); } else { resp
	 * = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST); }
	 * return resp; }
	 */

}
