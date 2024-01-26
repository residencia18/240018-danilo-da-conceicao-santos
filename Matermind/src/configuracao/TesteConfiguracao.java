package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteConfiguracao {
	
	@Test
	void testSetSenha() throws Exception {
		Configuracao configuracao = new Configuracao();
		String alfabeto = "abcd";
		configuracao.setAlfabeto(alfabeto);
		configuracao.setTamanhoSenha(3);
		
		String senha = "abc";
		Jogo jogo = new Jogo(configuracao);
		try {
			jogo.setSenha(senha);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(senha, jogo.getSenha());
		
		
		//---------------------------------------------//
		
		senha = "AS";
		configuracao = new Configuracao();
		alfabeto = "abcde";
		configuracao.setAlfabeto(alfabeto);
		configuracao.setTamanhoSenha(4);
		
		senha = "abc";
		jogo = new Jogo(configuracao);
		
		try {
			jogo.setSenha(senha);
		} catch (Exception e) {
			assertEquals("Senha deve ter mais de " + configuracao.getTamanhoSenha() +" caracter", e.getMessage());
		
		}
	}

	@Test
	void testSetAlfabeto() throws Exception {

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
		
		//-------------------------------------------------//
		tam = 11;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha não pode ser maior que o alfabeto (10 caracteres)", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());
		
		//-----tentativas
		
		int qtd = 4;
		try {
			configuracao.setQtdTentativas(qtd);	
		} catch (Exception e) {
			fail("Não era para gerar exception aqui");
		}
		//o tamanho da senha precisa ter sido aceito
		assertEquals(qtd, configuracao.getQtdTentativas());
		
		qtd = -1;
		try {
			configuracao.setQtdTentativas(qtd);	
			} catch (Exception e) {
			assertEquals("Não deveria gerar exception aqui para as tentativas", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(qtd, configuracao.getQtdTentativas());
		
		
		qtd = 1;
		try {
			configuracao.setQtdTentativas(qtd);	
			} catch (Exception e) {
			assertEquals("Tentativas deve ter mais que 1x", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(qtd, configuracao.getQtdTentativas());
		
		qtd = 0;
		try {
			configuracao.setQtdTentativas(qtd);	
			} catch (Exception e) {
			assertEquals("Tentativas deve ter mais que 1x", e.getMessage());
		}
		//o tamanho da senha não pode ter sido aceito
		assertNotEquals(qtd, configuracao.getQtdTentativas());

	}
	
	@Test
	void testListConfig() throws Exception {
		Configuracao configuracao = new Configuracao();
		Configuracao configuracao2 = new Configuracao();
		Configuracao config1= new Configuracao();
		Configuracao config2 = new Configuracao();
		
		configuracao.setAlfabeto("ASDF");
		configuracao2.setAlfabeto("ASDF");
		config1.setAlfabeto("ASD");
		config2.setAlfabeto("ASTU");
		ListaConfiguracoes  listaConfig = new ListaConfiguracoes ();
		String nome = "config1";
		try {
			listaConfig.setNomeArquivo(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nome, listaConfig.getNomeArquivo());
		
		//---------------------------------------------------------------//
		try {
			listaConfig.addConfigucao(configuracao);
			listaConfig.addConfigucao(config1);
			listaConfig.addConfigucao(config2);
		
		}catch (Exception e) {
			fail("Não era para gerar exception aqui");
		}
		assertEquals("ASDF", listaConfig.getLista().get(0).getAlfabeto());
		assertEquals("ASD", listaConfig.getLista().get(1).getAlfabeto());
		assertEquals("ASTU", listaConfig.getLista().get(2).getAlfabeto());

		
		//--------------------------------------------------------------//
		
		
		try {
			listaConfig = new ListaConfiguracoes ();
			listaConfig.addConfigucao(configuracao);
		
		}catch (Exception e) {
			fail("Não era para gerar exception aqui");
		}	
		
		try {
			listaConfig.addConfigucao(configuracao2);
		
		}catch (Exception e) {
			assertEquals("Valor já existe na lista", e.getMessage());	
		}
		assertEquals(1, listaConfig.getLista().size());
		
		//--------------------------------------------------------------//
		
		
		
	}
	

}
