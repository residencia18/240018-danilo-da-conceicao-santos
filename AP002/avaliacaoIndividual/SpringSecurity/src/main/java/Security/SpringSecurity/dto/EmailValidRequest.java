package Security.SpringSecurity.dto;

import jakarta.validation.constraints.Email;


public record EmailValidRequest(@Email String email) {

}
