package Security.SpringSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.dto.EmailValidRequest;
import Security.SpringSecurity.dto.NewPasswordRequest;
import Security.SpringSecurity.entity.Token;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.validation.ValidPassword;

@Service
public class PasswordRecoveryResetService {

    @Autowired
    TokenService tokenService;

    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationService authenticationService;

  
    public Boolean findUserAndSendEmail(EmailValidRequest email){

        Optional<User> userOptional = userService.findByEmail(email.email());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String token = tokenService.generateToken();
            tokenService.saveToken(token, user);
            String recoveryLink = "http://yoursite.com/api/auth/password-recovery?token=" + token;
            String emailBody = "Oi,\n\n Você solicitou a recuperação de senha. Clique no seguinte link para registrar uma nova senha:\n" + recoveryLink;
            emailService.sendEmail(email.email(), "Recuperação de senha", emailBody);
            return true;
        } else {
            return false;
        }
    }

    public Boolean changePassword(String token, @ValidPassword NewPasswordRequest newPassword){

        Token passwordResetToken = tokenService.findByToken(token);
        
        if (passwordResetToken != null) {
   
            if (!tokenService.isTokenExpired(passwordResetToken)) {

                Optional<User> updateUser = userService.findById(passwordResetToken.getUser().getId());
                User user = updateUser.get();
                authenticationService.changePassword(newPassword);
                user.setPassword(passwordEncoder.encode(newPassword.password()));
                userService.saveUser(user);
            
                tokenService.invalidateToken(token);
                return true;
            } else {
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token expirado.");
                return false;
            }
        } else {
            return false;
        }
    }
}
