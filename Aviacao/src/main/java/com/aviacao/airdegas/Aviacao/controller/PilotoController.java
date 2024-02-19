package com.aviacao.airdegas.Aviacao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviacao.airdegas.Aviacao.model.Piloto;
import com.aviacao.airdegas.Aviacao.repository.PilotoRepository;
@RestController
public class PilotoController {
	@Autowired
	private PilotoRepository pilotoRepository;
	
	@GetMapping("/Listarpilotos")
	public ArrayList<Piloto> listarPilotos(){
		List<Piloto> pilotos =  pilotoRepository.findAll();	
		return (ArrayList<Piloto>) pilotos;
	}
	

}
