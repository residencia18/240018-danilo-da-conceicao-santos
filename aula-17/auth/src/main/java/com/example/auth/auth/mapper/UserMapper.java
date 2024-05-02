package com.example.auth.auth.mapper;

import org.springframework.stereotype.Service;

import com.example.auth.auth.dto.RegisterRequest;
import com.example.auth.auth.entity.User;



@Service
public class UserMapper {

    public User fromRegisterRequest(RegisterRequest registerRequest) {
        return User.builder()
                .email(registerRequest.email())
                .username(registerRequest.username())
                .password(registerRequest.password())
                .role("ROLE_USER")
                .build();
    }
}
