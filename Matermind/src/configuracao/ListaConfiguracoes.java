package configuracao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListaConfiguracoes {
//	public static final String CAMINHO = "."+File.separator+"arquivos"+File.separator;
	
	private String nomeArquivo;
	private ArrayList<Configuracao> lista;
	
	public ListaConfiguracoes() {
		super();
//		nomeArquivo = CAMINHO+"configs.json";
		lista = new ArrayList<Configuracao>();
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public ArrayList<Configuracao> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Configuracao> lista) {
		this.lista = lista;
	}
	
	protected void addConfigucao(Configuracao config) throws Exception {
		
		for(Configuracao configuracao: lista) {
			if(configuracao.getAlfabeto() == config.getAlfabeto()) {
			   Exception e = new Exception("Valor já existe na lista");
	            throw e;
			}
		}
		lista.add(config);
		
	}
	

	
	
	
}
