package com.nfkdata.seed.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nfkdata.seed.domain.Welcome;
import com.nfkdata.seed.service.RootService;

import io.swagger.v3.oas.annotations.Operation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RootResourceTest {


	private static final String WELCOME_ENDPOINT_PATH = "/";
	private static final String WELCOME_METHOD_NAME = "welcome";
	private static final String WELCOME_METHOD_PRODUCES = "application/json";
	
	@Mock
	RootService rootService;
	
	@InjectMocks
	RootResource underTest;
	
	@Test
	public void testWelcome() {
		Mockito.when(rootService.buildWelcome()).thenReturn(new Welcome("Welcome to application name"));
		ResponseEntity<Welcome> response = underTest.welcome();
		assertTrue(response.getBody().getText().contains("Welcome to "));
	}
	
	@Test
	public void verifyClassAnnotations() {
		assertEquals(1, RootResource.class.getDeclaredAnnotations().length);
		assertTrue(RootResource.class.isAnnotationPresent(RestController.class));
	}
	
	@Test
	public void verifyWelcomeMethodAnnotations() throws NoSuchMethodException, SecurityException {
		Method welcomeMethod = IRootResource.class.getDeclaredMethod(WELCOME_METHOD_NAME);
		assertEquals(2, welcomeMethod.getDeclaredAnnotations().length);
		assertTrue(welcomeMethod.isAnnotationPresent(Operation.class));
		assertTrue(welcomeMethod.isAnnotationPresent(GetMapping.class));
		assertEquals(WELCOME_METHOD_PRODUCES, welcomeMethod.getDeclaredAnnotation(GetMapping.class).produces()[0]);
		assertEquals(WELCOME_ENDPOINT_PATH, welcomeMethod.getDeclaredAnnotation(GetMapping.class).path()[0]);
	}
	
}
