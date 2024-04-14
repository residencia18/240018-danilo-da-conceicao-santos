package com.nilosoft.product.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.ConstraintViolationException;

class UserTest {

	@Test
	public void testNameNotNull() {
	    String validName = "John Doe";
	    String nullName = null;

	    User user = new User(1L, validName, "johndoe@example.com", "1234567890", "password123");
	    assertThrows(NullPointerException.class, () -> user.setName(nullName));

	    assertDoesNotThrow(() -> user.setName(validName));
	}

}
