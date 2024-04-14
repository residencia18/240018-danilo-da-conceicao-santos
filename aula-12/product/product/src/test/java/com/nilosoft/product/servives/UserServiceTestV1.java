package com.nilosoft.product.servives;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.javafaker.Faker;
import com.nilosoft.product.model.User;
import com.nilosoft.product.repository.UserRepository;

class UserServiceTestV1 {

    @InjectMocks
    UserServiceV1 userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindById() {
    	Faker faker = new Faker();
        User user = new User(1L,faker.name().fullName(), faker.internet().emailAddress(), faker.phoneNumber().cellPhone(),faker.internet().password());
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.findById(1L);

        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
        assertEquals(user.getName(), foundUser.getName());
        assertEquals(user.getEmail(), foundUser.getEmail());
        assertEquals(user.getPhone(), foundUser.getPhone());
        assertEquals(user.getPassword(), foundUser.getPassword());
    }

    @Test
    void testSave() {
    	Faker faker = new Faker();
        User user = new User(1L,faker.name().fullName(), faker.internet().emailAddress(), faker.phoneNumber().cellPhone(),faker.internet().password());
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.save(user);

        assertNotNull(savedUser);
        assertEquals(user.getId(), savedUser.getId());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getPhone(), savedUser.getPhone());
        assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(userRepository).deleteById(id);

        assertDoesNotThrow(() -> userService.delete(id));
    }

    @Test
    void testUpdate() {
    	Faker faker = new Faker();
        User user = new User(1L,faker.name().fullName(), faker.internet().emailAddress(), faker.phoneNumber().cellPhone(),faker.internet().password());
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.update(1L, user);

        assertNotNull(updatedUser);
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals(user.getName(), updatedUser.getName());
        assertEquals(user.getEmail(), updatedUser.getEmail());
        assertEquals(user.getPhone(), updatedUser.getPhone());
        assertEquals(user.getPassword(), updatedUser.getPassword());
    }
}