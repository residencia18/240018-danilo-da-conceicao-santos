package Security.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.dto.ResetPasswordDTO;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.service.TokenService;
import Security.SpringSecurity.service.UserService;
import Security.SpringSecurity.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class PasswordResetController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenService tokenService;


    @PostMapping("/reset-password")
    public void resetPassword(@RequestBody ResetPasswordDTO dto) {
        String email = tokenService.getEmailByToken(dto.getToken());
        if (email != null) {
            // Validate the token and reset the user's password here
            userService.resetPassword(email, dto.getNewPassword());
            tokenService.invalidarToken(dto.getToken());
        }


    }
}
