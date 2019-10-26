package com.nfkdata.seed.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nfkdata.seed.domain.Welcome;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/")
public interface IRootResource {

	/**
	 * Endpoint for GET method
	 * 
	 * @return ResponseEntity with {@link Welcome} body and OK status}
	 */
	@Operation(description = "Root resource of the application", summary = "Returns a welcome message", responses = {
			@ApiResponse(responseCode = "200", description = "Welcome message", content = @Content(schema = @Schema(implementation = Welcome.class))) })
	@GetMapping(path = "/", produces = "application/json")
	ResponseEntity<Welcome> welcome();

}
