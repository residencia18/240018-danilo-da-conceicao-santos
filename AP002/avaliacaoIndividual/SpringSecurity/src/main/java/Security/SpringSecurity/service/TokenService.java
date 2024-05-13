//package Security.SpringSecurity.service;
//
//import java.time.Instant;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
//import org.springframework.stereotype.Service;
//
//import Security.SpringSecurity.entity.Token;
//import Security.SpringSecurity.entity.User;
//import Security.SpringSecurity.repository.TokenRepository;
//
//@Service
//public class TokenService {
//	@Autowired
//	private JwtEncoder jwtEncoder;
//	public static final Long EXPIRATION_TIME_IN_SECONDS = 3600L;
//
//	@Autowired
//	private TokenRepository tokenRepository;
//
//	public String generateToken(User user) {
//		var now = Instant.now();
//		JwtClaimsSet claims = JwtClaimsSet.builder()
//				.issuer("self")
//				.issuedAt(now)
//				.expiresAt(now.plusSeconds(EXPIRATION_TIME_IN_SECONDS))
//				.subject(user.getUsername())
//				.claim("scope", "ROLE_USER")
//				.build();
//		return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
//	}
//
//	public void saveToken(String token, User user) {
//		Token passwordResetToken = new Token();
//		passwordResetToken.setToken(token);
//		passwordResetToken.setUser(user);
//		passwordResetToken.setExpiryDate(new Date(System.currentTimeMillis() + Token.getExpiration() * 60 * 1000));
//		tokenRepository.save(passwordResetToken);
//	}
//
//	public Token findByToken(String token) {
//		Optional<Token> optionalToken = tokenRepository.findByToken(token);
//		if (optionalToken.isPresent()) {
//			Token passwordResetToken = optionalToken.get();
//			if (!isTokenExpired(passwordResetToken)) {
//				return passwordResetToken;
//			} else {
//				System.out.println("Expired token: " + token);
//			}
//		} else {
//			System.out.println("Token not found: " + token);
//		}
//		return null;
//	}
//
//	public void invalidateToken(String token) {
//		Optional<Token> optionalToken = tokenRepository.findByToken(token);
//		if (optionalToken.isPresent()) {
//			Token passwordResetToken = optionalToken.get();
//			tokenRepository.deleteByToken(passwordResetToken.getToken());
//		} else {
//			System.out.println("Token not found: " + token);
//		}
//	}
//
//	public boolean isTokenExpired(Token token) {
//		return token.getExpiryDate().before(new Date());
//	}
//}
package Security.SpringSecurity.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.Token;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.TokenRepository;



@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	
	public String generateToken() {
		return UUID.randomUUID().toString();
	}


	public void saveToken(String token, User user) {
		Token passwordResetToken = new Token();
		passwordResetToken.setToken(token);
		passwordResetToken.setUser(user);
	
		passwordResetToken
				.setExpiryDate(new Date(System.currentTimeMillis() + Token.getExpiration() * 60 * 1000));
	
		tokenRepository.save(passwordResetToken);
	}


	public Token findByToken(String token) {
		Optional<Token> optionalToken = tokenRepository.findByToken(token);
		if (optionalToken.isPresent()) {
			Token passwordResetToken = optionalToken.get();
			if (!isTokenExpired(passwordResetToken)) {
				return passwordResetToken;
			} else {
				System.out.println("Token expirado: " + token);
			}
		} else {
			System.out.println("Token não encontrado: " + token);
		}
		return null;
	}


	public void invalidateToken(String token) {
		Optional<Token> optionalToken = tokenRepository.findByToken(token);
		if (optionalToken.isPresent()) {
			Token passwordResetToken = optionalToken.get();
			tokenRepository.deleteByToken(passwordResetToken.getToken());
		} else {
			System.out.println("Token não encontrado: " + token);
		}
	}

	public boolean isTokenExpired(Token token) {
		return token.getExpiryDate().before(new Date());
	}
}

