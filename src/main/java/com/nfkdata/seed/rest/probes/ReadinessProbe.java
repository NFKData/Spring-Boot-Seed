package com.nfkdata.seed.rest.probes;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Checking the readiness status of the application
 */
@Endpoint(id = "ready")
@Component
public class ReadinessProbe {
	
	/**
	 * Called when checking the readiness status
	 * @return Health object with the current status and checks of the app
	 */
	@ReadOperation
	public ResponseEntity<Health> health() {
		return new ResponseEntity<>(Health.status(Status.UP).build(), HttpStatus.OK);
	}
}
