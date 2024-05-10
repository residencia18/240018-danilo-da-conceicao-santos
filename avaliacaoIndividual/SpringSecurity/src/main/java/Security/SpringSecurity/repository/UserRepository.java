package Security.SpringSecurity.repository;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Security.SpringSecurity.entity.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcClient jdbcClient;

    @Transactional
    public Long saveUser(User user) {
        var insertQuery = """
                INSERT INTO users(username, password, email, role) 
                VALUES(?, ?, ?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql(insertQuery)
                .param(1, user.getUsername())
                .param(2, user.getPassword())
                .param(3, user.getEmail())
                .param(4, user.getRole())
                .update();
        return keyHolder.getKeyAs(Long.class);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        var findQuery = "SELECT id, username, password, role, email FROM users WHERE username=:username";
        return jdbcClient.sql(findQuery).param("username", username).query(User.class).optional();
    }
    
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        var findQuery = "SELECT id, username, password, role, email FROM users WHERE id=:id";
        return jdbcClient.sql(findQuery).param("id", id).query(User.class).optional();
    }
    
    @Transactional
    public Optional<User> findByPasswordResetToken(String token) {
        var findQuery = "SELECT id, username, password, role, email, password_reset_token, password_reset_token_expiry FROM users WHERE password_reset_token = ?";
        
        return jdbcClient.sql(findQuery)
                .param(1, token)
                .query((rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    user.setEmail(rs.getString("email"));
                    return user;
                })
                .optional();
    }
    @Transactional
    public Optional<User> findByEmail(String email) {
        var findQuery = "SELECT id, username, password, role, email FROM users WHERE email = ?";
        
        return jdbcClient.sql(findQuery)
                .param(1, email)
                .query((rs, rowNum) -> {
                    User user = new User(); 
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    user.setEmail(rs.getString("email"));
                    return user;
                })
                .optional();
    }
    
    @Transactional
	public Optional<User> findByToken(String token) {
		var findQuery = "SELECT * FROM usuario WHERE token=:token";
		return jdbcClient.sql(findQuery)
				.param("token", token)
				.query(User.class).optional();
	}
    @Transactional
	public void updatePassword(String password, Long id) {
		var query = "UPDATE usuario SET password=:password WHERE id=:id";
		jdbcClient.sql(query)
		.param("password", password)
		.param("id", id)
		.update();
	}
}