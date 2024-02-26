package com.aviacao.airdegas.Aviacao.controller;

import java.net.URI;
import java.util.ArrayList;

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

import com.aviacao.airdegas.Aviacao.controller.FORM.pilotoFORM;
import com.aviacao.airdegas.Aviacao.model.Piloto;
import com.aviacao.airdegas.Aviacao.repository.PilotoRepository;

@RestController
@RequestMapping("/piloto/")

public class PilotoController {
	@Autowired
	private PilotoRepository pilotoRepository;
	
//	@GetMapping
//	public ArrayList<Piloto> listarPilotos(){
//		List<Piloto> pilotos =  pilotoRepository.findAll();	
//		return (ArrayList<Piloto>) pilotos;
//	}
	
	@GetMapping
	public ArrayList<Piloto> Pilotos(String name) {
		ArrayList<Piloto> lista ;
		
		if(name != null) {
			lista = (ArrayList<Piloto>) pilotoRepository.findByNome( name);			
		}
		else {		
			lista = (ArrayList<Piloto>) pilotoRepository.findAll();
		}
			
		return lista;
	}
	@PostMapping
	public ResponseEntity<Piloto> inserir(@RequestBody pilotoFORM pf, UriComponentsBuilder uriBuilder) {
		Piloto piloto = pf.criarPiloto();
		pilotoRepository.save(piloto);
		URI uri = uriBuilder.path("/piloto/{id}").buildAndExpand(piloto.getId()).toUri();
		return ResponseEntity.created(uri).body(piloto);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Piloto> deletar(@PathVariable Long id) {
		try {
			pilotoRepository.deleteById(id);
			return ResponseEntity.noContent().build();		
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();	
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Piloto> atualizar(@PathVariable Long id, @RequestBody pilotoFORM pf) {
		try {
			Piloto piloto = pilotoRepository.getReferenceById(id);
			piloto.setNome(pf.getNome());
			piloto.setNumBreve(pf.getNumbreve());
			Piloto p = pilotoRepository.save(piloto);
			return ResponseEntity.ok(p);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
