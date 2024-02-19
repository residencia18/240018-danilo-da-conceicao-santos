package com.degasoft.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.degasoft.redesocial.controller.dto.UsuarioDTO;
import com.degasoft.redesocial.modelo.Usuario;
import com.degasoft.redesocial.repository.UsuarioRepository;


@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioDTO> listarUsuarios() {
		List<Usuario> lista = (ArrayList<Usuario>) usuarioRepository.findAll();
		ArrayList<UsuarioDTO> listaDTO = new ArrayList<UsuarioDTO>();
		for(Usuario u : lista) {
			UsuarioDTO uDTO = new UsuarioDTO(u.getId(), u.getNome(), u.getEmail());
			listaDTO.add(uDTO);
		}
		return listaDTO;
	}
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping("/listarUsuarios")
//	public ArrayList<Usuario> listarUsuarios() {
//		ArrayList<Usuario> lista = new ArrayList<Usuario>();
//		Usuario u1 = new Usuario("Rafael", "r@r.com", "123");
//		Usuario u2 = new Usuario("Joao", "j@j.com", "123");
//		Usuario u3 = new Usuario("Maria", "m@m.com", "123");
//		Usuario u4 = new Usuario("Pedro", "p@p.com", "123");
//		lista.add(u1);
//		lista.add(u2);
//		lista.add(u3);
//		lista.add(u4);
//		return lista;
//	};

}
