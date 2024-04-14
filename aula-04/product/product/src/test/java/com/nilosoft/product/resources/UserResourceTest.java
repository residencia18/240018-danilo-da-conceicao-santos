package com.nilosoft.product.resources;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nilosoft.product.model.User;
import com.nilosoft.product.servives.UserService;



	class UserResourceTest {

	    @InjectMocks
	    UserResource userResource;

	    @Mock
	    UserService userService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    void testFindAll() {
	        List<User> userList = new ArrayList<>();
	        userList.add(new User(1L, "John Doe", "john@example.com", "1234567890", "password123"));

	        when(userService.findAll()).thenReturn(userList);

	        ResponseEntity<List<User>> responseEntity = userResource.FindAll();

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(userList, responseEntity.getBody());
	    }

	    @Test
	    void testFindById() {
	        Long userId = 1L;
	        User user = new User(userId, "John Doe", "john@example.com", "1234567890", "password123");

	        when(userService.findById(userId)).thenReturn(user);

	        ResponseEntity<User> responseEntity = userResource.findById(userId);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(user, responseEntity.getBody());
	    }

	    @Test
	    void testCreate() {
	        User user = new User(1L, "John Doe", "john@example.com", "1234567890", "password123");

	        when(userService.save(user)).thenReturn(user);

	        ResponseEntity<User> responseEntity = userResource.create(user);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(user, responseEntity.getBody());
	    }

	    @Test
	    void testUpdate() {
	        Long userId = 1L;
	        User user = new User(userId, "John Doe", "john@example.com", "1234567890", "password123");

	        when(userService.update(userId, user)).thenReturn(user);

	        ResponseEntity<User> responseEntity = userResource.update(userId, user);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(user, responseEntity.getBody());
	    }

	    @Test
	    void testDelete() {
	        Long userId = 1L;

	        assertDoesNotThrow(() -> userResource.delete(userId));
	    }

	    @Test
	    void testHandleNoSuchElementException() {
	        NoSuchElementException exception = new NoSuchElementException("User not found");

	        ResponseEntity<String> responseEntity = userResource.handleNoSuchElementException(exception);

	        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	        assertEquals("User not found", responseEntity.getBody());
	    }
	}