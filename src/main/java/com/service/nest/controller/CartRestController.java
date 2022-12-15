package com.service.nest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.nest.domainI.CartDetails;
import com.service.nest.domainI.CartService;
import com.service.nest.domainI.JobDetails;

@RestController
@RequestMapping("/serviceNest/cart")
public class CartRestController {

	@Autowired
	private CartService cartService;

	@PutMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody JobDetails jobDetails) {

		ResponseEntity<String> resp = null;

		try {
			Long idL = cartService.addToCart(jobDetails);
			resp = new ResponseEntity<String>("Added to cart succesfully with id: " + idL, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

	@GetMapping("/viewCart")
	public ResponseEntity<?> viewCart(@RequestParam Long cartId) {

		ResponseEntity<?> resp = null;

		try {
			CartDetails idL = cartService.viewCart(cartId);
			resp = new ResponseEntity<CartDetails>(idL, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

}
