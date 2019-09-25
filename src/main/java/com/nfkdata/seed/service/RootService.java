package com.nfkdata.seed.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nfkdata.seed.domain.Welcome;

/**
 * Service used on Root Endpoint
 */
@Service
public class RootService {

	/**
	 * Name of the current application
	 */
	@Value(value = "${spring.application.name}")
	private String applicationName;
	
	/**
	 * Build the response body for Welcome page
	 * @return {@link Welcome}
	 */
	public Welcome buildWelcome() {
		return new Welcome("Welcome to " + applicationName);
	}

}
