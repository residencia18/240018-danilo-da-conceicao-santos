package Security.SpringSecurity.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import Security.SpringSecurity.entity.Token;


public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

    void deleteById(Long id);

    @Transactional
    @Modifying
    void deleteByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE token prt SET prt.token = 'EXPIRED' WHERE prt.token = :token")
    void invalidateToken(String token);
}

