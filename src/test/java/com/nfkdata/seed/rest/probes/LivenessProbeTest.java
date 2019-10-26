package com.nfkdata.seed.rest.probes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivenessProbeTest {

	@InjectMocks
	private LivenessProbe underTest;
	
	@Test
	public void testHealth() {
		Health result = underTest.health();
		assertEquals(Status.UP, result.getStatus());
	}

	@Test
	public void verifyClassAnnotations() {
		assertEquals(1, LivenessProbe.class.getDeclaredAnnotations().length);
		assertTrue(LivenessProbe.class.isAnnotationPresent(Component.class));
	}
}
