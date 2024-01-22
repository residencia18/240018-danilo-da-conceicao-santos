package quadrado;

public class Quadrado {
	private String estado;
	
	
	
	public Quadrado(String estado) {
		super();
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void clique(int tecla) {
		if (tecla==1) {
			inverte(0);
			inverte(1);
			inverte(3);
		}
		if (tecla==2) {
			inverte(0);
			inverte(1);
			inverte(2);
		}	
		if (tecla==5) {
			inverte(3);
			inverte(7);
			inverte(1);
			inverte(5);
			inverte(4);
		}
		if (tecla==6) {
			inverte(2);
			inverte(5);
			inverte(8);
		}
		if (tecla==7) {
			inverte(3);
			inverte(6);
			inverte(7);
		}
		if (tecla==8) {
			inverte(6);
			inverte(7);
			inverte(8);
		}
		if (tecla==9) {
			inverte(7);
			inverte(8);
			inverte(5);
		}
		if (tecla==3) {
			inverte(1);
			inverte(2);
			inverte(5);
		}
		if (tecla==4) {
			inverte(0);
			inverte(3);
			inverte(6);
		}
	}
	
	/**
	 * Este método inverte um caracter da string estado.
	 * Se era X vira O, e vice versa
	 * @param i
	 */
	protected void inverte(int i) {
		char c = estado.charAt(i);
		if (c=='O')
			c='X';
		else
			c='O';
		StringBuilder s = new StringBuilder(estado);
		s.setCharAt(i, c);
		estado = s.toString();
	}
	
}
