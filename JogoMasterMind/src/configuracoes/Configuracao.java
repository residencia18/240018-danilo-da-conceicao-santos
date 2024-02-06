package configuracoes;

import utils.StringManager;

public class Configuracao {
	
	private String nome, alfabeto;
	private int tamanhoSenha, maxTentativas;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMaxTentativas() {
		return maxTentativas;
	}

	public void setMaxTentativas(int maxTentativas) throws Exception {
		if (maxTentativas <= 0) {
			Exception e = new Exception("Deve haver pelo menos 1 tentativa");
			throw e;
		}
		this.maxTentativas = maxTentativas;
	}

	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tamanhoSenha) throws Exception {
		if (tamanhoSenha <=0) {
			Exception e = new Exception("Senha deve ter ao menos 1 caracter");
			throw e;
		}
		if (tamanhoSenha > alfabeto.length()) {
			Exception e = new Exception("Senha não pode ser maior que o alfabeto ("+alfabeto.length()+" caracteres)");
			throw e;
		}
		this.tamanhoSenha = tamanhoSenha;
	}

	public String getAlfabeto() {
		return alfabeto;
	}
	
	public void setAlfabeto(String alfabeto) throws Exception {
		if ((alfabeto==null) || (alfabeto.length() < 2) ) {
			Exception e = new Exception("O alfabeto deve possuir mais de 1 caracter");
			throw e;
		}
		boolean r = StringManager.checaRepetido(alfabeto);
		if (r) {
			Exception e = new Exception("Não podem haver caracteres repetidos no alfabeto");
			throw e;
		}
		this.alfabeto = alfabeto;
	}
	
	public String toString() {
		return "Nome: "+nome+"   Alfabeto: "+alfabeto+"    Senha com "+tamanhoSenha+" caracteres  e "+maxTentativas+ " tentativas";
	}
	


}
