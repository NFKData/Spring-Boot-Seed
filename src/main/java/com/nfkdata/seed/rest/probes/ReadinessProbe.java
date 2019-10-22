package com.nfkdata.seed.rest.probes;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Endpoint(id = "ready")
@Component
public class ReadinessProbe {
	@ReadOperation
	public ResponseEntity<Health> health() {
		return new ResponseEntity<>(Health.status(Status.UP).build(), HttpStatus.OK);
	}
}
