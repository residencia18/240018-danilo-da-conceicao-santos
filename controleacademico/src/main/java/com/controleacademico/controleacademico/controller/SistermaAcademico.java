package com.controleacademico.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SistermaAcademico {
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
