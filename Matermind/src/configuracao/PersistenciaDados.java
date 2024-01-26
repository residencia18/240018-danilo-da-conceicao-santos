package configuracao;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;


public class PersistenciaDados {
	public static final String CAMINHO = "/home/mikaelle/eclipse-workspace/Matermind/";
	
	File file_ = new File(CAMINHO);	
	protected JSONObject obterDadosEstudante(Configuracao config) throws Exception {
		try {
			JSONObject configuracao = new JSONObject();
			configuracao.put("Nome", config.getAlfabeto());
			configuracao.put("Idade", config.getTamanhoSenha());
			
			return configuracao;
			
		}catch (Exception e) {
			throw new Exception("Valor já existe na lista", e);
	    }
	}
	
	protected boolean SalvarArrayJson(String nomeArquivo) {
		
		return true;
	}
	
}
