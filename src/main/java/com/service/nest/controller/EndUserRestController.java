package com.service.nest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.nest.domainI.LoginUser;
import com.service.nest.domainI.User;
import com.service.nest.domainI.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/serviceNest/endUser")
public class EndUserRestController {

	@Autowired
	private UserService userService;// HAS-A

	@PostMapping("/create")
	public ResponseEntity<String> registerNewUser(@RequestBody User user) {
		ResponseEntity<String> resp = null;
		try {
			Long id = userService.registerNewUser(user);
			resp = new ResponseEntity<String>("saved with:" + id, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	


	/*
	 * @GetMapping("/all") public ResponseEntity<?> getAllEndUsers() {
	 * 
	 * ResponseEntity<?> resp = null; try { List<EndUser> list =
	 * service.getAllEndUsers(); if (list == null || list.isEmpty()) { resp = new
	 * ResponseEntity<String>("NO DATA FOUND", HttpStatus.OK); } else { resp = new
	 * ResponseEntity<List<EndUser>>(list, HttpStatus.OK); } } catch (Exception e) {
	 * e.printStackTrace(); resp = new ResponseEntity<String>(e.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); } return resp; }
	 */

	/**
	 * 4. Fetch one row by id
	 */
	/*
	 * @GetMapping("/byId") public ResponseEntity<?> getEndUserById(@RequestParam
	 * Long endUserId) { ResponseEntity<?> resp = null; Optional<EndUser> ob =
	 * service.getEnduserById(endUserId); if (ob.isPresent()) { resp = new
	 * ResponseEntity<EndUser>(ob.get(), HttpStatus.OK); } else { resp = new
	 * ResponseEntity<String>(endUserId + "Data Not Found ",
	 * HttpStatus.BAD_REQUEST); } return resp; }
	 */

	/*
	 * @PutMapping("/modify") public ResponseEntity<String> updateUser(@RequestBody
	 * EndUser endUser) throws ServiceNestException { ResponseEntity<String> resp =
	 * null; Long id = endUser.getUserId(); boolean exist = service.isExist(id); if
	 * (exist) { service.saveEndUser(endUser); resp = new
	 * ResponseEntity<String>("Updated SuccessFully", HttpStatus.OK); } else { resp
	 * = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST); }
	 * return resp; }
	 */
	@PostMapping("/login")
	public ResponseEntity<String> loginEndUser(@RequestBody LoginUser user) {
		ResponseEntity<String> resp = null;
		try {
			boolean validUser = userService.isValidLogin(user);
			if (validUser)
				resp = new ResponseEntity<String>("succesfully logged in ", HttpStatus.OK);
			else {
				resp = new ResponseEntity<String>("Invalid Login credentials", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

}
