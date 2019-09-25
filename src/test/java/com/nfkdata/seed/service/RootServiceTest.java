package com.nfkdata.seed.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RootServiceTest {

	private static final String APPLICATION_NAME_FIELD_NAME = "applicationName";
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Autowired
	RootService underTest;
	
	@Test
	public void testBuildWelcome() {
		assertEquals("Welcome to " + applicationName, underTest.buildWelcome().getText());
	}
	
	@Test
	public void verifyApplicationNameField() throws NoSuchFieldException, SecurityException {
		Field applicationNameField = RootService.class.getDeclaredField(APPLICATION_NAME_FIELD_NAME);
		assertNotNull(applicationNameField);
		assertEquals(1, applicationNameField.getDeclaredAnnotations().length);
		assertTrue(applicationNameField.isAnnotationPresent(Value.class));
	}

}
