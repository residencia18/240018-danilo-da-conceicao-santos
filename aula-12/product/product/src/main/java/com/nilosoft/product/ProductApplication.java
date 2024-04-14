package com.nilosoft.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {
	public static final Logger log = LoggerFactory.getLogger(ProductApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
		log.info("Aplicação iniciada com sucesso!");
	}

}
