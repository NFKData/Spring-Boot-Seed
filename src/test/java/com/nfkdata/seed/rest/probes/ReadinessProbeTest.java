package com.nfkdata.seed.rest.probes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadinessProbeTest {

	private static final String HEALTH_METHOD = "health";
	
	@InjectMocks
	private ReadinessProbe underTest;
	
	@Test
	public void testHealth() {
		ResponseEntity<Health> result = underTest.health();
		assertEquals(Status.UP, result.getBody().getStatus());
	}

	@Test
	public void verifyClassAnnotations() {
		assertEquals(2, ReadinessProbe.class.getDeclaredAnnotations().length);
		assertTrue(ReadinessProbe.class.isAnnotationPresent(Component.class));
		assertTrue(ReadinessProbe.class.isAnnotationPresent(Endpoint.class));
	}
	
	@Test
	public void verifyHealthMethodAnnotations() throws NoSuchMethodException, SecurityException {
		Method healthMethod = ReadinessProbe.class.getDeclaredMethod(HEALTH_METHOD);
		assertEquals(1, healthMethod.getDeclaredAnnotations().length);
		assertTrue(healthMethod.isAnnotationPresent(ReadOperation.class));
	}

}
