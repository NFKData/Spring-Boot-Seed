package com.nfkdata.seed.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfkdata.seed.domain.Welcome;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RootResourceTest {


	private static final String WELCOME_METHOD_NAME = "welcome";
	private static final String WELCOME_METHOD_PRODUCES = "application/json";

	private static final String APPLICATION_NAME_FIELD_NAME = "applicationName";

	@Autowired
	RootResource underTest;
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@Test
	public void testWelcome() {
		ResponseEntity<Welcome> response = underTest.welcome();
		assertEquals("Welcome to " + applicationName, response.getBody().getText());
	}
	
	@Test
	public void verifyClassAnnotations() {
		assertEquals(1, RootResource.class.getDeclaredAnnotations().length);
		assertTrue(RootResource.class.isAnnotationPresent(RestController.class));
	}
	
	@Test
	public void verifyWelcomeMethodAnnotations() throws NoSuchMethodException, SecurityException {
		Method welcomeMethod = RootResource.class.getDeclaredMethod(WELCOME_METHOD_NAME);
		assertEquals(1, welcomeMethod.getDeclaredAnnotations().length);
		assertTrue(welcomeMethod.isAnnotationPresent(GetMapping.class));
		assertEquals(WELCOME_METHOD_PRODUCES, welcomeMethod.getDeclaredAnnotation(GetMapping.class).produces()[0]);
	}
	
	@Test
	public void verifyApplicationNameField() throws NoSuchFieldException, SecurityException {
		Field applicationNameField = RootResource.class.getDeclaredField(APPLICATION_NAME_FIELD_NAME);
		assertNotNull(applicationNameField);
		assertEquals(1, applicationNameField.getDeclaredAnnotations().length);
		assertTrue(applicationNameField.isAnnotationPresent(Value.class));
	}

}
