package configuracao;

import java.io.File;
import java.util.ArrayList;

public class ListaConfiguracoes {
public static final String CAMINHO = "."+File.separator+"arquivos"+File.separator;
	
	private String nomeArquivo;
	private ArrayList<Configuracao> lista;
	public ListaConfiguracoes() {
		super();
		nomeArquivo = CAMINHO+"configs.json";
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
	
	public void salva(Configuracao configuracao) {
		
	}
	public void VerificaNome(String nome)throws Exception {
		if(lista.contains(nome)) {
			throw new Exception("Nome já existe");
		}
	}

	public void novaConfiguracao(Configuracao config1)throws Exception {
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNome().equals(config1.getNome())) {
				throw new Exception("Nome já existe");
			}
		}		
		VerificaNome(config1.getNome());
		lista.add(config1);
		
		
	}
}
