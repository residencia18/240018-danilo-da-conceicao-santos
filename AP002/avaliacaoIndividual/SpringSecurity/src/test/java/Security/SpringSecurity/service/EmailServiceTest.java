package Security.SpringSecurity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void testSendEmail_Success() {
      
        String destinatario = "test@email.com";
        String assunto = "Assunto do email";
        String mensagem = "Mensagem do email";

     
        String result = emailService.sendEmail(destinatario, assunto, mensagem);

     
        assertEquals("Email enviado", result);
    }

    
}
