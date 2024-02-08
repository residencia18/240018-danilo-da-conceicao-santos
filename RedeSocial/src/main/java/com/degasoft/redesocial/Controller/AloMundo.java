package com.degasoft.redesocial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AloMundo {
	@RequestMapping("/")
	@ResponseBody // para retornar o dados
	public String mensagem() {
		return " Sou o cara";
	}
	
	@RequestMapping("/secreta")
	@ResponseBody // para retornar o dados
	public String secreta() {
		return " Sua hora chegou";
	}
	@RequestMapping("/s")
	@ResponseBody // para retornar o dados
	public String s() {
		return " Russia";
	}
}
