package Security.SpringSecurity.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Security.SpringSecurity.entity.Token;

@DataJpaTest
class TokenRepositoryTest {

    @Autowired
    private TokenRepository tokenRepository;

    @Test
    void testFindByToken() {
        // Criar um token de exemplo para encontrar no repositório
        String tokenValue = "example_token_value";
        Token token = new Token();
        token.setToken(tokenValue);
        tokenRepository.save(token);

        // Verificar se o token pode ser encontrado no repositório
        Token foundToken = tokenRepository.findByToken(tokenValue).orElse(null);
        assertNotNull(foundToken);
        assertEquals(tokenValue, foundToken.getToken());
    }

   
}
