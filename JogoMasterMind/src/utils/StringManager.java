package utils;

public class StringManager {
	
	public static boolean checaRepetido(String alfabeto) {
		for (int i=0;i< alfabeto.length(); i++) {
			char c1 = alfabeto.charAt(i);
			for (int j=i+1;j<alfabeto.length(); j++) {
				char c2 = alfabeto.charAt(j);
				if (c1==c2)
					return true;
			}
		}
		return false;
	}

	public static boolean contem(String alfabeto, String tentativa) {
		for (int i=0;i<tentativa.length(); i++) {
			char c = tentativa.charAt(i);
			if (alfabeto.indexOf(c)==-1)
				return false;
		}
		return true;
	}


}
