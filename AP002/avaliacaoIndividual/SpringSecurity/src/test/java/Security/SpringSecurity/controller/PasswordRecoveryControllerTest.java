package Security.SpringSecurity.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Security.SpringSecurity.dto.EmailValidRequest;
import Security.SpringSecurity.service.PasswordRecoveryResetService;

@ExtendWith(MockitoExtension.class)
public class PasswordRecoveryControllerTest {

    @InjectMocks
    private PasswordRecoveryController passwordRecoveryController;

    @Mock
    private PasswordRecoveryResetService passwordRecoveryResetService;

    @Test
    public void testRequestPasswordRecovery_Success() {
        // Arrange
        EmailValidRequest emailValidRequest = new EmailValidRequest("test@email.com");
        when(passwordRecoveryResetService.findUserAndSendEmail(emailValidRequest)).thenReturn(true);

     
        ResponseEntity<String> response = passwordRecoveryController.requestPasswordRecovery(emailValidRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Um e-mail de recuperação de senha foi enviado para test@email.com", response.getBody());
    }

    @Test
    public void testRequestPasswordRecovery_Failure() {
        // Arrange
        EmailValidRequest emailValidRequest = new EmailValidRequest("test@email.com");
        when(passwordRecoveryResetService.findUserAndSendEmail(emailValidRequest)).thenReturn(false);

        // Act
        ResponseEntity<String> response = passwordRecoveryController.requestPasswordRecovery(emailValidRequest);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Ocorreu um erro ao processar a solicitação de recuperação de senha", response.getBody());
    }
}
