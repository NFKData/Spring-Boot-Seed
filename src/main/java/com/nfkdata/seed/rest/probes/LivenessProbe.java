package com.nfkdata.seed.rest.probes;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class LivenessProbe implements HealthIndicator{

	@Override
	public Health health() {
		return Health.status(Status.UP).build();
	}

}
