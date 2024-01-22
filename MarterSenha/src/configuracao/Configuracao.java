package configuracao;

public class Configuracao {
	private String alfabeto;

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto)throws Exception {
		if(alfabeto == null ) {			
			throw new IllegalArgumentException("O alfabeto deve ser nullo");		
		}
		
		
		if(alfabeto.length() < 2) {
			throw new IllegalArgumentException("O alfabeto deve possuir mais de 1 caracter");
		}
		this.alfabeto = alfabeto;
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