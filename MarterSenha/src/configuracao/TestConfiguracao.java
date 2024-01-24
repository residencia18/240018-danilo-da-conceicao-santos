package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConfiguracao {

	@Test
	void testSetAlfabeto() throws Exception{
				Configuracao configuracao = new Configuracao();
				String senha = "abcd";
				configuracao.setAlfabeto(senha);
				assertEquals(senha,configuracao.getAlfabeto());
			
				
			//***********caso 1 : tentar enserir uma Senha null
			
			senha = null;
			
			try {
				configuracao.setAlfabeto(senha);
			}catch(Exception e) {
				assertEquals("O alfabeto deve ser nullo", e.getMessage());
			}
			assertFalse(configuracao.getAlfabeto()==null);
					
			//***********caso 2 : tentar enserir uma Senha 1 caracter
			
			senha = "A";
			try {
				configuracao.setAlfabeto(senha);
			}catch(Exception e) {
				assertEquals("O alfabeto deve possuir mais de 1 caracter", e.getMessage());
			}
			assertFalse(configuracao.getAlfabeto()==null);			
	}	
			
	@Test		
	void testSetTamanhoSenha() throws Exception{
			Configuracao configuracao = new Configuracao();
			String senha = "abcd";
			configuracao.setAlfabeto(senha);
			
		//Caso geral: um tamanho de senha válido (entre 1 e 4)	
		int tam = 2;
				try {
					configuracao.setTamanhoSenha(tam);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		//Caso tentar inserir uma senha de tamanho negativo
				int tamanho = -1;
				try {
				    configuracao.setTamanhoSenha(tamanho);
				} catch (Exception e) {
				    assertEquals("Senha deve ter ao menos 1 caracter", e.getMessage());
				}
		//Caso 2 versão 2: inserir com sucesso senha de tamanho igual ao alfabeto (que tem 4 caracteres)
			int tamanho2 = 4;
			try {
				configuracao.setTamanhoSenha(tamanho2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(tamanho2, configuracao.getTamanhoSenha());
	}
	@Test
	void testMaximoTentativas() throws Exception{
		Configuracao configuracao = new Configuracao();
		String senha = "abcd";
		configuracao.setAlfabeto(senha);
		configuracao.setMaximoTentativas(3);
	}	
}


