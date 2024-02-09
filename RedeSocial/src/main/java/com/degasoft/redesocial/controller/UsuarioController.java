package com.degasoft.redesocial.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.degasoft.redesocial.modelo.Usuario;


@RestController
public class UsuarioController {
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("Rafael", "r@r.com", "123");
		Usuario u2 = new Usuario("Joao", "j@j.com", "123");
		Usuario u3 = new Usuario("Maria", "m@m.com", "123");
		Usuario u4 = new Usuario("Pedro", "p@p.com", "123");
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		lista.add(u4);
		return lista;
	};

}
