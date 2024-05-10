package Security.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.service.EmailService;
import Security.SpringSecurity.service.TokenService;

@RestController
@RequestMapping("/api")
public class PasswordRecoveryController {
    
    @Autowired
    private EmailService emailService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/recover-password")
    public ResponseEntity<String> recoverPassword(@RequestBody String email) {
        try {
            // Validar o formato do e-mail
            if (!isValidEmail(email)) {
                return ResponseEntity.badRequest().body("E-mail inválido");
            }

            // Gerar e armazenar o token de recuperação de senha
            String token = tokenService.gerarToken(email);

            // Enviar o e-mail com o link de recuperação contendo o token gerado
            String recoveryLink = "http://localhost:8080/reset-password?token=" + token;
            String body = "Click on the link below to reset your password:\n" + recoveryLink;

            emailService.sendEmail(email, "Password Recovery", body);

            return ResponseEntity.ok("Um e-mail de recuperação de senha foi enviado para " + email);
        } catch (Exception e) {
            // Tratar qualquer exceção que possa ocorrer durante o processo de recuperação de senha
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Ocorreu um erro ao processar a solicitação de recuperação de senha");
        }
    }

    // Método para validar o formato do e-mail
    private boolean isValidEmail(String email) {
       
        return true; // Altere de acordo com sua lógica de validação
    }
}
