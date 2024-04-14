package com.nilosoft.product.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.github.javafaker.Faker;
import com.nilosoft.product.model.User;

@DataJpaTest
@ActiveProfiles("test") // Use a separate profile for tests (optional)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
    	Faker faker = new Faker();
        user = new User(1L,faker.name().fullName(), faker.internet().emailAddress(), faker.phoneNumber().cellPhone(),faker.internet().password());
        userRepository.save(user);
    }

    @Test
    public void testFindById_ShouldReturnUser_WhenUserExists() {
        Optional<User> retrievedUser = userRepository.findById(user.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals(user, retrievedUser.get());
    }
    
    

   
}
