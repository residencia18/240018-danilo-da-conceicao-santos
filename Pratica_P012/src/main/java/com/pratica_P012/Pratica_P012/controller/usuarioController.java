package com.pratica_P012.Pratica_P012.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usuarioController {
	@RequestMapping("/")
	@ResponseBody // para retornar o dados
	public String mensagem() {
		return " Seus dias estao contados";
	}
	
	@RequestMapping("/nome")
	@ResponseBody // para retornar o dados
	public String nome() {
		return " Sua hora chegou";
	}
	
	@RequestMapping("/s")
	@ResponseBody // para retornar o dados
	public String s() {
		return " Russia";
	}
}
