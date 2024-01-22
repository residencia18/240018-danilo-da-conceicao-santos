package configuracao;

public class Configuracao {
	private String alfabeto;

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
	
	
}
