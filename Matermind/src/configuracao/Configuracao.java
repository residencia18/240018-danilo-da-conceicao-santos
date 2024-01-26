package configuracao;

public class Configuracao {
	private String alfabeto;
	
	private int tamanhoSenha;
	private int qtdTentativas;
	
	
	public int getQtdTentativas() {
		return qtdTentativas;
	}

	public void setQtdTentativas(int qtdTentativas) throws Exception {
		if (qtdTentativas < 0) {
			   Exception e = new Exception("Não deveria gerar exception aqui para as tentativas");
	            throw e;
			}
		if (qtdTentativas == 1|| qtdTentativas == 0) {
			   Exception e = new Exception("Tentativas deve ter mais que 1x");
	            throw e;
			}
		this.qtdTentativas = qtdTentativas;
	}

	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tam) throws Exception {
		if(tam < 0) {
			Exception e = new Exception("Senha deve ter ao menos 1 caracter");
			throw e;
		}
		if(tam>10) {
		   Exception e = new Exception("Senha não pode ser maior que o alfabeto (10 caracteres)");
            throw e;
		}
		if (tam < 1 || tam > 4) {
		   Exception e = new Exception("Não deveria gerar exception aqui");
            throw e;
		}
		
		this.tamanhoSenha = tam;
	}

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {

        if ((alfabeto == null) || (alfabeto.isEmpty()) || (alfabeto.length() < 2)) {
            Exception e = new Exception("O alfabeto deve possuir mais de 1 caracter");
            throw e;
        }
        boolean result = checarRepetido(alfabeto);
        if(result) {
            Exception e = new Exception("Não podem haver caracter repetidos");
            throw e;
        }
        this.alfabeto = alfabeto;
	  
	}
	
	protected boolean checarRepetido(String alfabeto) {
		for(int i = 0; i< alfabeto.length(); i++) {
			char c1 = alfabeto.charAt(i);
			for(int j=i+1; j<alfabeto.length();j++) {
				char c2 =  alfabeto.charAt(j);
				if(c1 ==c2) {
					return true;
				}
			}
		}
		 return false;
		 
	}

}
