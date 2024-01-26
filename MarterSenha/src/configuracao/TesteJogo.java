package configuracao;

import org.junit.jupiter.api.Test;

class TesteJogo {

	@Test
	void test() {
		void testSetAlfabeto() throws Exception;{
			Configuracao configuracao = new Configuracao();
			String senha = "ACDE";
			configuracao.setAlfabeto(senha);
			configuracao.setTamanhoSenha(4);
			try {
				configuracao.setSenha(senha);
				
			}catch(Exception e) {
				assertEquals("Apenas o alfabeto ABCDE deve ser inserido", e.getMessage());
			}
			assertNotEquals(senha,jogo.getSenha());
		}
	}

}
