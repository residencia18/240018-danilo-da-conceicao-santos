package Security.SpringSecurity.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private Map<String, String> tokens = new HashMap<>();

    public String gerarToken(String email) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, email);
        return token;
    }

    public String recuperarEmailPorToken(String token) {
        return tokens.get(token);
    }

    public void invalidarToken(String token) {
        tokens.remove(token);
    }

	public String getEmailByToken(String token) {
		return tokens.get(token);

	}
}
