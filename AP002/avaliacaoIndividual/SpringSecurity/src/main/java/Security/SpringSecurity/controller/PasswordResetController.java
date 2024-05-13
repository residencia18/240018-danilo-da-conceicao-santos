package Security.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Security.SpringSecurity.dto.NewPasswordRequest;
import Security.SpringSecurity.service.PasswordRecoveryResetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PasswordResetController {

    private final PasswordRecoveryResetService changePasswordService;

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestBody NewPasswordRequest newPassword) {
        if (changePasswordService.changePassword(token, newPassword)) { 
            return ResponseEntity.status(HttpStatus.OK).body("Password updated with success!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token.");
        }
    }
}
