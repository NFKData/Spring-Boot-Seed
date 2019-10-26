package com.nfkdata.seed.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.nfkdata.seed.domain.Welcome;
import com.nfkdata.seed.service.RootService;

/**
 * Rest Controller for / path
 */
@RestController
public class RootResource implements IRootResource {
	
	/**
	 * Service used for business logic
	 */
	@Autowired
	private RootService rootService;
	
	@Override
	public ResponseEntity<Welcome> welcome() {
		return new ResponseEntity<>(rootService.buildWelcome(), HttpStatus.OK);
	}	
	
}
