package configuracoes;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONException;

import persistencia.Persistencia;



public class ListaConfiguracoes {
	
	public static final String CAMINHO = "."+File.separator+"arquivos"+File.separator;
	
	private String nomeArquivo;
	private ArrayList<Configuracao> lista;
	public ListaConfiguracoes() {
		super();
		nomeArquivo = CAMINHO+"configs.json";
		lista = new ArrayList<Configuracao>();
	}
	
	public void novaConfiguracao(Configuracao nova) throws Exception {
		if (contemNome(nova)) {
			Exception e = new Exception("Configuração \""+nova.getNome()+"\" já existe");
			throw e;
		}
		else {
			lista.add(nova);
			Persistencia.salvaConfiguracoes(lista, nomeArquivo);
		}
	}
	
	/**
	 * @param nova
	 * @return
	 */
	protected boolean contemNome(Configuracao nova) {
		for (Configuracao c: lista) {
			if (c.getNome().equals(nova.getNome())) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Configuracao> getLista() {
		return lista;
	}
	
	protected String getNomeArquivo() {
		return nomeArquivo;
	}

	/**
	 * Não testado!
	 * @throws Exception 
	 * @throws JSONException 
	 */
	public void leDados() throws JSONException, Exception {
		lista = Persistencia.leConfiguracoes(nomeArquivo);
	}

}
