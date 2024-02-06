package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import configuracoes.Configuracao;

public class Persistencia {

	/**
	 * Salva a lista de configuracoes num arquivo json
	 * @param lista
	 * @param nomeArquivo
	 * @throws IOException 
	 */
	public static void salvaConfiguracoes(ArrayList<Configuracao> lista, String nomeArquivo) throws IOException {
		File arquivo = new File(nomeArquivo);
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		for (Configuracao conf: lista) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("nome", conf.getNome());
			jsonObject.put("alfabeto", conf.getAlfabeto());
			jsonObject.put("tamanho", conf.getTamanhoSenha());
			jsonObject.put("maxtentativas", conf.getMaxTentativas());
			bw.write(jsonObject.toString());
		}
		bw.close();
		fw.close();
	}

	/**
	 * Recupera a lista de configuracoes do arquivo json
	 * @param nomeArquivo
	 * @return
	 * @throws Exception 
	 * @throws JSONException 
	 */
	public static ArrayList<Configuracao> leConfiguracoes(String nomeArquivo) throws JSONException, Exception {
		ArrayList<Configuracao> lista = new ArrayList<Configuracao>();
		File arquivo = new File(nomeArquivo);
		if (!arquivo.exists())
			return lista;
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String linha = ";";
		while ( (linha = br.readLine()) !=null) {
			JSONObject jsonObject = new JSONObject(linha);
			Configuracao conf = new Configuracao();
			conf.setNome(jsonObject.getString("nome"));
			conf.setAlfabeto(jsonObject.getString("alfabeto"));
			conf.setTamanhoSenha(jsonObject.getInt("tamanho"));
			conf.setMaxTentativas(jsonObject.getInt("maxtentativas"));
			lista.add(conf);
		}
		br.close();
		fr.close();
		return lista;
	}

}
