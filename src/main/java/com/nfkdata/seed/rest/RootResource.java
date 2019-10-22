package com.nfkdata.seed.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfkdata.seed.domain.Welcome;
import com.nfkdata.seed.service.RootService;

/**
 * Rest Controller for / path
 */
@RestController("/")
public class RootResource {
	
	/**
	 * Service used for business logic
	 */
	@Autowired
	private RootService rootService;
	
	/**
	 * Endpoint for GET method
	 * @return ResponseEntity with {@link Welcome} body and OK status}
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<Welcome> welcome() {
		return new ResponseEntity<>(rootService.buildWelcome(), HttpStatus.OK);
	}	
	
}
