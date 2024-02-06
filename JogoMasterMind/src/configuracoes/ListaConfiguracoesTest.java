package configuracoes;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

class ListaConfiguracoesTest {
	
	@Test
	public void testContemNome() throws Exception {
		//create Strings with new to avoid the String Pool
		Configuracao c0 = new Configuracao();
		c0.setNome(new String("Conf 0"));
		Configuracao c1 = new Configuracao();
		c1.setNome(new String("Conf 1"));
		Configuracao c2 = new Configuracao();
		c2.setNome(new String("Conf 2"));
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		//não pode conter nenhum nome
		assertFalse(listaConfiguracoes.contemNome(c0));
		listaConfiguracoes.novaConfiguracao(c0);
		assertTrue(listaConfiguracoes.contemNome(c0));
		assertFalse(listaConfiguracoes.contemNome(c1));
		listaConfiguracoes.novaConfiguracao(c1);
		assertTrue(listaConfiguracoes.contemNome(c1));
		assertFalse(listaConfiguracoes.contemNome(c2));
		listaConfiguracoes.novaConfiguracao(c2);
		Configuracao repetida = new Configuracao();
		repetida.setNome(new String("Conf 1"));
		assertTrue(listaConfiguracoes.contemNome(repetida));
	}
	

	@Test
	public void testNovaConfiguracao() {
		Configuracao c0 = new Configuracao();
		c0.setNome("Conf 0");
		Configuracao c1 = new Configuracao();
		c1.setNome("Conf 1");
		Configuracao c2 = new Configuracao();
		c2.setNome("Conf 2");
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		
		//caso geral: acrescentar uma lista perfeitamente válida
		assertEquals(0, listaConfiguracoes.getLista().size());
		try {
			listaConfiguracoes.novaConfiguracao(c0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		assertEquals(3, listaConfiguracoes.getLista().size());
		assertEquals("Conf 0", listaConfiguracoes.getLista().get(0).getNome());
		assertEquals("Conf 1", listaConfiguracoes.getLista().get(1).getNome());
		assertEquals("Conf 2", listaConfiguracoes.getLista().get(2).getNome());
		
		//caso 1: tentar acrescentar um nome repetido
		listaConfiguracoes = new ListaConfiguracoes();
		c0.setNome("Conf 0");
		c1.setNome("Conf 0");
		try {
			listaConfiguracoes.novaConfiguracao(c0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c1);
		} catch (Exception e) {
			//deve gerar a exceção correta 
			assertEquals("Configuração \"Conf 0\" já existe", e.getMessage());
		}
		//não pode inserir na lista
		assertEquals(1, listaConfiguracoes.getLista().size());
	}
	
	//verificar se está salvando e recuperando corretamente do arquivo
	@Test
	public void testSalvaRecupera() throws Exception {
		Configuracao c0 = new Configuracao();
		c0.setNome("Conf 0");
		c0.setAlfabeto("ABCDE");
		c0.setMaxTentativas(3);
		c0.setTamanhoSenha(2);
		Configuracao c1 = new Configuracao();
		c1.setNome("Conf 1");
		c1.setAlfabeto("ABCDE");
		c1.setMaxTentativas(3);
		c1.setTamanhoSenha(2);
		Configuracao c2 = new Configuracao();
		c2.setNome("Conf 2");
		c2.setAlfabeto("ABCDE");
		c2.setMaxTentativas(3);
		c2.setTamanhoSenha(2);
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		
		//caso geral: acrescentar uma lista perfeitamente válida
		assertEquals(0, listaConfiguracoes.getLista().size());
		try {
			listaConfiguracoes.novaConfiguracao(c0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.novaConfiguracao(c2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		
		//deveremos ter 3 configuracoes salvas no arquivo
		listaConfiguracoes = new ListaConfiguracoes();
		try {
			listaConfiguracoes.leDados();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
