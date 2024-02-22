package com.degasoft.redesocial.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.degasoft.redesocial.controller.Form.UsuarioForm;
import com.degasoft.redesocial.controller.dto.UsuarioDTO;
import com.degasoft.redesocial.modelo.Usuario;
import com.degasoft.redesocial.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	

	@GetMapping
	public ArrayList<UsuarioDTO> listarUsuarios(String name) {
		System.out.println(name);
		List<Usuario> lista;
		if(name != null) {
			lista = (ArrayList<Usuario>) usuarioRepository.findByNome( name);			
		}
		else {		
			lista = (ArrayList<Usuario>) usuarioRepository.findAll();
		}
		
		
		ArrayList<UsuarioDTO> listaDTO = new ArrayList<UsuarioDTO>();
		for(Usuario u : lista) {
			UsuarioDTO uDTO = new UsuarioDTO(u.getId(), u.getNome(), u.getEmail());
			listaDTO.add(uDTO);
		}
		return listaDTO;
	}
//	@PostMapping	
//	public UsuarioDTO inserirUsuario(@RequestBody UsuarioForm uf) {
//		Usuario usuario = uf.criarUsuario();
//		usuarioRepository.save(usuario);
//		UsuarioDTO uDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
//		return uDTO;
//	}
////////////////////////////////////	
//	@PostMapping	
//	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioForm uf) {
//		Usuario usuario = uf.criarUsuario();
//		usuarioRepository.save(usuario);
//		UsuarioDTO uDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
	
	@PostMapping	
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioForm usuarioform ,UriComponentsBuilder uribuilder) {				
		Usuario usuario = usuarioform.criarUsuario();
		usuarioRepository.save(usuario);
		UsuarioDTO uDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
		uribuilder.path("/usuario/{id}");
		URI uri = uribuilder.buildAndExpand(usuario.getId()).toUri();
	
		return  ResponseEntity.created(uri).body(uDTO);
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

