package com.nilosoft.product.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nilosoft.product.model.User;
import com.nilosoft.product.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@.com", "988888888", "988888888",null);
		User u2 = new User(null, "Alex Green", "alex@.com", "977777777", "977777777",null);
		User u3 = new User(null, "Bob Brown", "bob@.com", "966666666", "966666666",null);
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}

}
