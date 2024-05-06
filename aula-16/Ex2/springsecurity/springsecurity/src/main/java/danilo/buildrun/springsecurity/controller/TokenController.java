package danilo.buildrun.springsecurity.controller;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import danilo.buildrun.springsecurity.controller.dto.LoginRequest;
import danilo.buildrun.springsecurity.controller.dto.LoginResponse;
import danilo.buildrun.springsecurity.repository.UserRepository;

public class TokenController {

	private final JwtEncoder jwtEncoder;
	
	private final UserRepository userRepository;

	private BCryptPasswordEncoder passwordEncoder;
	
	public TokenController(JwtEncoder jwtEncoder,  UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.jwtEncoder = jwtEncoder;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        var user = userRepository.findByUsername(loginRequest.username());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("user or password is invalid!");
        }

        var now = Instant.now();
        var expiresIn = 300L;

       
        var claims = JwtClaimsSet.builder()
                .issuer("mybackend")
                .subject(user.get().getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var jwtValue = "";

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }
}
