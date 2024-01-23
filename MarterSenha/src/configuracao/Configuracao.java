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