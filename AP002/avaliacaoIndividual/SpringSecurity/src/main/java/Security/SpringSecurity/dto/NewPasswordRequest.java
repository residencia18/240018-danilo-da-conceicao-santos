package Security.SpringSecurity.dto;

import Security.SpringSecurity.validation.ValidPassword;

public record NewPasswordRequest(@ValidPassword String password) {
    
}

