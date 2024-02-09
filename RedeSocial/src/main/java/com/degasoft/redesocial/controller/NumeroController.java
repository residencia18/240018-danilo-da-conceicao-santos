package com.degasoft.redesocial.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.degasoft.redesocial.rsa.*;


@RestController
public class NumeroController {
	private int valor = 0;
	private int numero ;
	
	@RequestMapping("/numero")
	public int getValor() {
		return valor;
	}
	
	@RequestMapping("/numeroAleatorio")
	 public  int gerarNumeroPrimoAleatorio() {
        Random random = new Random();
        int numeroAleatorio;       
            numeroAleatorio = random.nextInt(1000000) + 2;  
        return numeroAleatorio;
    }
	
	@RequestMapping("/sequencia")
	public int sequencia() {
		return valor++;
	}
	
	
	@RequestMapping("/k")
	public String key()
	{
		RSAGenerator generator = new RSAGenerator(12345);
		generator.getPrivatekey();
		generator.getPublickey();
		
		return generator.toString() ;
		
		
	}
	
}
