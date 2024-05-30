package Security.SpringSecurity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Security.SpringSecurity.entity.User;

class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void testFindByEmail_shouldFindUser_whenEmailExists() {
    // Cenário: Criar um usuário com email válido e salvá-lo no banco
    String testEmail = "teste@email.com";
    User user = User.builder()
      .email(testEmail)
      .username("teste_user")
      // ... outras propriedades do usuário
      .build();
    userRepository.save(user);

    // Ação: Buscar usuário pelo email cadastrado
    Optional<User> foundUser = userRepository.findByEmail(testEmail);

    // Asserção: Verificar se o usuário foi encontrado
    assertTrue(foundUser.isPresent());
    assertEquals(testEmail, foundUser.get().getEmail());

    // Limpeza (opcional): Remover o usuário de teste do banco
    userRepository.deleteById(user.getId());
  }

  @Test
  public void testFindByEmail_shouldReturnEmptyOptional_whenEmailNotFound() {
    // Cenário: Nenhum usuário com o email de teste existe no banco

    // Ação: Buscar usuário por um email que não existe
    String nonExistingEmail = "nao_cadastrado@email.com";
    Optional<User> foundUser = userRepository.findByEmail(nonExistingEmail);

    // Asserção: Verificar se nenhum usuário foi encontrado
    assertFalse(foundUser.isPresent());
  }
}
