package com.nilosoft.product.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilosoft.product.model.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> FindAll() {
		User user = new User(1L, "Marcos", "marcos@.com", "123456789", "123456789");
		return ResponseEntity.ok().body(user);
	}
}
