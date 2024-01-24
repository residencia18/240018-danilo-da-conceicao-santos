package configuracao;

public class Configuracao {
	private String nome;
	private String alfabeto;
	private int tamanhoSenha;
	private int maximoTentativas;

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) {
		if(alfabeto != null && alfabeto.length() > 2 ) {	
			boolean temRepetido  = false;
			for (int i = 0; i < alfabeto.length() - 1; i++) {
		        for (int j = i + 1; j < alfabeto.length(); j++) {
		            if (alfabeto.charAt(i) == alfabeto.charAt(j)) {
		            	temRepetido = true;
		                break;
		            }
		        }
		        if (temRepetido) {
		            break;
		        }
		    }
		    if (!temRepetido) {
		        this.alfabeto = alfabeto;
		    }
		}
	}
	 public void setTamanhoSenha(int tamanho) throws Exception {
	        if (tamanho <= 0) {
	            throw new Exception("Senha deve ter ao menos 1 caracter");
	        } else if (tamanho > 4) {
		        throw new Exception("Senha deve ter no máximo 4 caracteres");
	        } 
	        
	        this.tamanhoSenha = tamanho;
	    }
	 
	public int getTamanhoSenha() {
		return tamanhoSenha;
	}
	public int getMaximoTentativas() {
		return maximoTentativas;
	}
	public void setMaximoTentativas(int maximoTentativas)throws Exception{
		if(maximoTentativas <= 0) {
			   throw new Exception("Tentativas deve ter pelo menos 1");
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
	
//			for (int i = 0; i < alfabeto.length(); i++) {
//				
//				for (int j = i+1; j < alfabeto.length(); j++) {
//					if(alfabeto.charAt(i) == alfabeto.charAt(j)) {
//						temRepitido = true;
//					}
//				}
//			}
//			if(alfabeto.charAt(0) == alfabeto.charAt(alfabeto.length()-1)) {
//				temRepitido = true;			
//			}else if(alfabeto.charAt(0) == alfabeto.charAt(1)) {
//				temRepitido = true;
//			}else if(alfabeto.charAt(alfabeto.length()-1) == alfabeto.charAt(alfabeto.length()-2)) {
//				temRepitido = true;
//			}else if(alfabeto.charAt(1) == alfabeto.charAt(2)) {
//				temRepitido = true;
//			}
//			else if(alfabeto.charAt(alfabeto.length()/2) == alfabeto.charAt(alfabeto.length()-1)) {
//				temRepitido = true;
//			}else if(alfabeto.charAt(alfabeto.length()/2) == alfabeto.charAt(alfabeto.length()-2)) {
//				temRepitido = true;
//			}
//			if(!temRepitido) {
//				this.alfabeto = alfabeto;
//			}