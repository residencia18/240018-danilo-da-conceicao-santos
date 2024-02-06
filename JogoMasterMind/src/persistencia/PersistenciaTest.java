package persistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import configuracoes.Configuracao;
import configuracoes.ListaConfiguracoes;

class PersistenciaTest {
	
	@Test
	void testaLeConfiguracoes() {
		try {
			ArrayList<Configuracao> lista = Persistencia.leConfiguracoes("teste.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testSalvaConfiguracoes() throws Exception {	
		Configuracao c0 = new Configuracao();
		c0.setNome("Conf 0");
		c0.setAlfabeto("ABC");
		c0.setTamanhoSenha(2);
		c0.setMaxTentativas(5);
		Configuracao c1 = new Configuracao();
		c1.setNome("Conf 1");
		c1.setAlfabeto("ABC");
		c1.setTamanhoSenha(2);
		c1.setMaxTentativas(5);
		Configuracao c2 = new Configuracao();
		c2.setNome("Conf 2");
		c2.setAlfabeto("ABC");
		c2.setTamanhoSenha(2);
		c2.setMaxTentativas(5);
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		listaConfiguracoes.getLista().add(c0);
		listaConfiguracoes.getLista().add(c1);
		listaConfiguracoes.getLista().add(c2);
		
		try {
			Persistencia.salvaConfiguracoes(listaConfiguracoes.getLista(), "teste.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
