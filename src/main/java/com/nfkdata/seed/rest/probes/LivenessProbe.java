package com.nfkdata.seed.rest.probes;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Checking the alive status of the application
 */
@Component
public class LivenessProbe implements HealthIndicator {

	/**
	 * Called when checking the alive status
	 * @return Health object with the current status and checks of the app
	 */
	@Override
	public Health health() {
		return Health.status(Status.UP).build();
	}

}
