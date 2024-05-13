package Security.SpringSecurity.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.dto.EmailValidRequest;
import Security.SpringSecurity.service.PasswordRecoveryResetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api") 
@RequiredArgsConstructor 
public class PasswordRecoveryController {

    
    @Autowired
    private final PasswordRecoveryResetService changePasswordService;

  
    @PostMapping("/recover-password")
    public ResponseEntity<String> requestPasswordRecovery(@RequestBody EmailValidRequest email) {
    	 try {
	        changePasswordService.findUserAndSendEmail(email);
	          
	        	 return ResponseEntity.ok("Um e-mail de recuperação de senha foi enviado para " + email);       	           
	        
    	 } catch (Exception e) {
             // Tratar qualquer exceção que possa ocorrer durante o processo de recuperação de senha
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                  .body("Ocorreu um erro ao processar a solicitação de recuperação de senha");
         }  
    }

}

