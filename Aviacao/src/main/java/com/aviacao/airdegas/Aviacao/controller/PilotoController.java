package com.aviacao.airdegas.Aviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
