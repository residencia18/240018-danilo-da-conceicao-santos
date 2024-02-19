package com.pratica_P012.Pratica_P012.modelo;

public class Vencedor {
    private String pais;
    private String piloto;
    private int vitorias;
    
    public Vencedor(String pais, String piloto, int vitorias) {
        this.pais = pais;
        this.piloto = piloto;
        this.vitorias = vitorias;
    }
    
    // Getters e setters aqui


	
	public Vencedor() {
		super();
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	
}
