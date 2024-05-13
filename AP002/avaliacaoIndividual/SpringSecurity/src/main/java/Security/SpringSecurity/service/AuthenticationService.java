package Security.SpringSecurity.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.LoginRequest;
import Security.SpringSecurity.dto.LoginResponse;
import Security.SpringSecurity.dto.NewPasswordRequest;
import Security.SpringSecurity.dto.RegisterRequest;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.mapper.UserMapper;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.security.JwtProvider;
import Security.SpringSecurity.validation.PasswordConstraintValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    public void register(RegisterRequest registerRequest) {
        User user = userMapper.fromRegisterRequest(registerRequest);// Usando o UserMapper para criar o objeto User
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(),
                loginRequest.password()));
        String token = jwtProvider.generateToken(authenticate);
        return new LoginResponse(token);
    }
    
    boolean isPasswordValid(String password) {
        PasswordConstraintValidator validator = new PasswordConstraintValidator();
        return validator.isValid(password, null);
    }

    // Method to change user password
    public void changePassword(@Valid NewPasswordRequest newPasswordRequest){
        if(!isPasswordValid(newPasswordRequest.password())){
            // Handle invalid password
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Invalid password. You must create a stronger password: at least 8 characters (Use A-Z, a-z, and symbols) ");
            throw new IllegalArgumentException("Invalid password.");
        }
    }
}