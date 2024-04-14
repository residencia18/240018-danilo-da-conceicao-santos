package com.danilosoft.Produto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication {
	public static final Logger log = LoggerFactory.getLogger(ProdutoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
		log.info("Aplicação iniciada com sucesso!");
	}

}
