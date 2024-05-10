//package Security.SpringSecurity.controller;
//
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import Security.SpringSecurity.dto.ResetPasswordDTO;
//import Security.SpringSecurity.repository.UserRepository;
//import Security.SpringSecurity.service.TokenService;
//import Security.SpringSecurity.service.UserDetailsServiceImpl;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//
//
//@RestController
//@RequiredArgsConstructor
//public class PasswordResetController {
//	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordRecoveryController.class);
//	
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final TokenService tokenService;
//
//   
//    @PostMapping("/redefinir-senha")
//    public ResponseEntity resetPassword(@RequestBody @Valid ResetPasswordDTO data) {
//    	User user = this.userRepository.findByEmail(data.email()).orElseThrow(()->new RuntimeException("User not found "));
//    	LOGGER.info("Executando operação de Resetar senha .{}{}{}", data.email(), data.newPassword());
// 
//    	try {
//    		String token = this.tokenService.gerarToken(data.newPassword());
//    		user.setPassword(this.passwordEncoder.encode(data.newPassword()));
//    		
//    		this.userRepository.save(user);
//
//    		return ResponseEntity.ok().build();
//    	
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//       }
//    }
//}