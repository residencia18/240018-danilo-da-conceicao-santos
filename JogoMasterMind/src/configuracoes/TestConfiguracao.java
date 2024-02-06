package configuracoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestConfiguracao {
	

	@Test
	void testSetAlfabeto() {
		Configuracao configuracao = new Configuracao();
		
		//Caso geral: salvar uma senha válida
		String alfabeto = "ABCDEFGH";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Gerou exceção indevida");
			e1.printStackTrace();
		}
		assertEquals(alfabeto, configuracao.getAlfabeto());
		
		//*******************Caso 1: tentar inserir uma senha null
		alfabeto = null;
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
			assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto()==null);
		
		
		//*******************Caso 3: Tentar inserir uma senha com um único caractere
		alfabeto = "X";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
		}
		//temos que ter certeza que o string "X" não foi salvo
		assertFalse(configuracao.getAlfabeto()=="X");
		
		//*******************Caso 4: Tentar uma senha com caracteres repetidos
		//Caso 4.1 - Testar 2 caracteres iguais no começo da String
		alfabeto = "AACDEFGHIJK";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
		
		//Caso 4.2 - Testar 2 caracteres iguais no final da String
		alfabeto = "ABCDEFGHIJJ";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
		
		//Caso 4.3 - Testar 2 caracteres iguais no final da String
		alfabeto = "ABCDEFGHIJA";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
		
		//Caso 4.4 - Testar 1 caracter intermediário e outro no fim
		alfabeto = "ABCDKFGHIJK";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
		
		//Caso 4.5 - Testar 1 caracter intermediário e outro no fim
		alfabeto = "ABCDEFGAIJK";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
		
		//Caso 4.6 - Testar 2 caracteres em posições intermediárias adjacentes
		alfabeto = "ABCDEFFHIJK";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
		
		//Caso 4.7 - Testar 2 caracteres em posições intermediárias não adjacentes
		alfabeto = "ABCDEFGHDJK";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// temos que ter certeza que a mensagem está correta
						assertEquals("Não podem haver caracteres repetidos no alfabeto", e.getMessage());
		}
		//temos que ter certeza que o string não foi salvo
		assertNotEquals(alfabeto, configuracao.getAlfabeto());
	}
	
	@Test
	void testSetTamanhoSenha() {
		Configuracao configuracao = new Configuracao();
		//definindo um alfabeto (o teste do método que define o alfabeto já existe!)
		String alfabeto = "abcd";
		try {
			configuracao.setAlfabeto(alfabeto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Caso geral: um tamanho de senha válido (entre 1 e 4)
		int tam = 2;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exception aqui");
			e1.printStackTrace();
		}
		assertEquals(tam, configuracao.getTamanhoSenha());
		
		//Caso 1: tentar inserir uma senha de tamanho negativo
		tam = -1;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha deve ter ao menos 1 caracter", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());
		
		//Caso 1 versão 2: tentar inserir uma senha de tamanho 0
		tam = 0;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha deve ter ao menos 1 caracter", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());
		
		//Caso 2: tentar inserir senha de tamanho maior que o alfabeto (que tem 4 caracteres)
		tam = 5;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha não pode ser maior que o alfabeto (4 caracteres)", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());
		
		//Caso 2 versão 2: inserir com sucesso senha de tamanho iguao ao alfabeto (que tem 4 caracteres)
		tam = 4;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			fail("Não era para gerar exception aqui");
		}
		//o tamanho da senha precisa ter sido aceito
		assertEquals(tam, configuracao.getTamanhoSenha());
		
		//Caso 2 versão 3: tentar inserir senha de tamanho maior que o alfabeto (que agora tem 10 caracteres)
		try {
			configuracao.setAlfabeto("1234567890");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tam = 11;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha não pode ser maior que o alfabeto (10 caracteres)", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());
	}
	
	@Test
	public void testSetMaxTentativas() {
		Configuracao configuracao = new Configuracao();
		//caso geral: um número qualquer de tentativas
		try {
			configuracao.setMaxTentativas(5);
		} catch (Exception e) {
			fail("Não deveria gerar exception aqui");
		}
		//tem que ter aceitado o valor
		assertEquals(5, configuracao.getMaxTentativas());
		
		//Caso 1 versão 1: tentar inserir 0 tentativas
		try {
			configuracao.setMaxTentativas(0);
		} catch (Exception e) {
			assertEquals("Deve haver pelo menos 1 tentativa", e.getMessage());
		}
		//não pode ter aceitado
		assertNotEquals(0, configuracao.getMaxTentativas());
		
		//Caso 1 versão 2: tentar inserir menos que 0 tentativas
		try {
			configuracao.setMaxTentativas(-1);
		} catch (Exception e) {
			assertEquals("Deve haver pelo menos 1 tentativa", e.getMessage());
		}
		//não pode ter aceitado
		assertNotEquals(-1, configuracao.getMaxTentativas());
	}

}
