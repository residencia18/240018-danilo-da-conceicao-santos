package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lance {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Leilao leilao;

    @ManyToOne
    private Concorrente concorrente;

    private double valor;
    

    public Lance() {
        super();
    }
    
    public Lance(Leilao leilao, Concorrente concorrente, double valor) {
        super();
        this.leilao = leilao;
        this.concorrente = concorrente;
        this.valor = valor;
    }
    
    public Lance(Long id, Leilao leilao, Concorrente concorrente, double valor) {
        super();
        this.id = id;
        this.leilao = leilao;
        this.concorrente = concorrente;
        this.valor = valor;
    }



	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

	public Concorrente getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(Concorrente concorrente) {
		this.concorrente = concorrente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}


