package Security.SpringSecurity.dto;

public record ResetPasswordDTO(String token, String newPassword,String confirmPassword ) {

}
