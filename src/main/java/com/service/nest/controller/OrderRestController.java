package com.service.nest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.nest.domainI.OrderService;

@RestController
@RequestMapping("serviceNest/order")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService; // HAS A, coding to interface
	
	
	@PostMapping("confrimOrder")
	public ResponseEntity<String> confrimOrder(
			@RequestParam Long cartId, @RequestParam Long addressId) 
	{
		ResponseEntity<String> resp=null;
		try {
			Long id=orderService.bookService(cartId, addressId);
			resp=new ResponseEntity<String>("saved with: assigned professional will contact you"+id, HttpStatus.OK);  
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	} 
	
	
	
	
	
	
	

}
