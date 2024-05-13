package Security.SpringSecurity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import Security.SpringSecurity.entity.User;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindById() {
        // Criar um usuário de exemplo
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("test_user");
        
        // Salvar o usuário no banco de dados
        userRepository.save(user);
        
        // Buscar o usuário pelo ID
        Optional<User> foundUserOptional = userRepository.findById(user.getId());
        
        // Verificar se o usuário foi encontrado corretamente
        assertEquals(user, foundUserOptional.orElse(null));
    }

    @Test
    void testFindByEmail() {
        // Criar um usuário de exemplo
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("test_user");
        
        // Salvar o usuário no banco de dados
        userRepository.save(user);
        
        // Buscar o usuário pelo email
        Optional<User> foundUserOptional = userRepository.findByEmail(user.getEmail());
        
        // Verificar se o usuário foi encontrado corretamente
        assertEquals(user, foundUserOptional.orElse(null));
    }
}
