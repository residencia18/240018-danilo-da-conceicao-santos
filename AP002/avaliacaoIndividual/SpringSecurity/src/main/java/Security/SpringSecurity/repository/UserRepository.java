package Security.SpringSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Security.SpringSecurity.entity.User;
import lombok.RequiredArgsConstructor;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findById(Long id);

	Optional<User> findByUsername(String username);
    
	Optional<User> findByEmail(String email);
}