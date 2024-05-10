package Security.SpringSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long id){
    	return userRepository.findById(id);
    }
    
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    

	public void saveUser(User user) {
		userRepository.saveUser(user);
		
	}


	public void resetPassword(String email, String newPassword) {
	    Optional<User> user = userRepository.findByEmail(email);
	    if (user.isPresent()) {
	        user.get().setPassword(newPassword);
	        userRepository.saveUser(user.get());
	    }
	}

  
}
