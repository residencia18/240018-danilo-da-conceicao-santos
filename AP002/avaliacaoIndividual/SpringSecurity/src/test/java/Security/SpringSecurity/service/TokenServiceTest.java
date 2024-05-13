package Security.SpringSecurity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Security.SpringSecurity.entity.Token;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.TokenRepository;

@ExtendWith(MockitoExtension.class)
public class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    @Mock
    private TokenRepository tokenRepository;

    @Test
    public void testGenerateToken() {
  
        String token = tokenService.generateToken();

     
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    public void testSaveToken() {
      
        String token = "test-token";
        User user = new User();
        user.setId(1L);

        tokenService.saveToken(token, user);

        // Assert
        Token savedToken = tokenRepository.findByToken(token).get();
        assertEquals(token, savedToken.getToken());
        assertEquals(user, savedToken.getUser());
        assertNotNull(savedToken.getExpiryDate());
    }

    @Test
    public void testFindByToken_ValidToken() {
     
        String token = "test-token";
        User user = new User();
        user.setId(1L);
        Token savedToken = new Token(null, token, user, new Date(System.currentTimeMillis() + Token.getExpiration() * 60 * 1000));
        when(tokenRepository.findByToken(token)).thenReturn(Optional.of(savedToken));

        
        Token foundToken = tokenService.findByToken(token);

       
        assertNotNull(foundToken);
        assertEquals(token, foundToken.getToken());
        assertEquals(user, foundToken.getUser());
        assertFalse(tokenService.isTokenExpired(foundToken));
    }

    @Test
    public void testFindByToken_ExpiredToken() {
        
        String token = "test-token";
        User user = new User();
        user.setId(1L);
        Token savedToken = new Token(null, token, user, new Date(System.currentTimeMillis() - Token.getExpiration() * 60 * 1000));
        when(tokenRepository.findByToken(token)).thenReturn(Optional.of(savedToken));

    
        Token foundToken = tokenService.findByToken(token);

      
        assertNull(foundToken);
    }

    @Test
    public void testFindByToken_InvalidToken() {
        
        String token = "test-token";
        when(tokenRepository.findByToken(token)).thenReturn(Optional.empty());

        
        Token foundToken = tokenService.findByToken(token);

    
        assertNull(foundToken);
    }

    @Test
    public void testInvalidateToken() {
    
        String token = "test-token";
        User user = new User();
        user.setId(1L);
        Token savedToken = new Token(null, token, user, new Date(System.currentTimeMillis() + Token.getExpiration() * 60 * 1000));
        when(tokenRepository.findByToken(token)).thenReturn(Optional.of(savedToken));

       
        tokenService.invalidateToken(token);

        
        Token foundToken = tokenRepository.findByToken(token).get();
        assertNull(foundToken);
    }

}
        
        
