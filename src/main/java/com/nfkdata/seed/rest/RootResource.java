package com.nfkdata.seed.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfkdata.seed.domain.Welcome;

/**
 * Rest Controller for / path
 */
@RestController
public class RootResource {

	/**
	 * Name of the current application
	 */
	@Value(value = "${spring.application.name}")
	private String applicationName;
	
	/**
	 * Endpoint for GET method
	 * @return ResponseEntity with {@link Welcome} body and OK status}
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<Welcome> welcome() {
		return new ResponseEntity<>(new Welcome("Welcome to " + applicationName), HttpStatus.OK);
	}	
	
}
