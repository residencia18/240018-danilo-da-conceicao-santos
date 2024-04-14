package com.danilosoft.Produto.controller;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.danilosoft.Produto.ProdutoApplication;
import com.danilosoft.Produto.controller.dto.UsuarioDTO;
import com.danilosoft.Produto.controller.form.UsuarioForm;
import com.danilosoft.Produto.model.Usuario;
import com.danilosoft.Produto.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
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
		log.info("Usuários listados com sucesso!");
		return listaDTO;
	}
	
	@PostMapping	
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioForm usuarioform ,UriComponentsBuilder uribuilder) {				
		Usuario usuario = usuarioform.criarUsuario();
		usuarioRepository.save(usuario);
		UsuarioDTO uDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
		uribuilder.path("/usuario/{id}");
		URI uri = uribuilder.buildAndExpand(usuario.getId()).toUri();
		
		log.info("Usuário criado com sucesso!");
		return  ResponseEntity.created(uri).body(uDTO);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> listaUsuario(@PathVariable Long id, UriComponentsBuilder uribuilder) {
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			UsuarioDTO uDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
			uribuilder.path("/usuario/{id}");			
			return ResponseEntity.ok(uDTO);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> updateUsuarioId(@PathVariable Long id, @RequestBody UsuarioForm uf) {
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			usuario.setNome(uf.getNome());
			usuario.setEmail(uf.getEmail());
			usuario.setSenha(uf.getSenha());
			usuarioRepository.save(usuario);
			UsuarioDTO uDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
			
			return ResponseEntity.ok(uDTO);
		}catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
			
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDTO> deleteUsuarioId(@PathVariable Long id) {
		try {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
}
	@DeleteMapping("/")
	public ResponseEntity<UsuarioDTO> deleteUsuario() {
			return ResponseEntity.badRequest().build();		
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
