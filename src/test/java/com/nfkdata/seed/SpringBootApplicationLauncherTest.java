package com.nfkdata.seed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationLauncherTest {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void verifyClassAnnotations() {
		assertEquals(1, SpringBootApplicationLauncher.class.getDeclaredAnnotations().length);
		assertTrue(SpringBootApplicationLauncher.class.isAnnotationPresent(SpringBootApplication.class));
		assertNotEquals(0, SpringBootApplicationLauncher.class.getDeclaredAnnotation(SpringBootApplication.class).scanBasePackages().length);
	}

}
