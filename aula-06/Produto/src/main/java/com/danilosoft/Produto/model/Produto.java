package com.danilosoft.Produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
public class Produto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	private double precoCusto;
	private double precoVista;
	private double precoPrazo;
	private int quantidade;
	
	
	
}

