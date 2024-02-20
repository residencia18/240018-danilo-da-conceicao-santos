package com.aviacao.airdegas.Aviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviacao.airdegas.Aviacao.model.Aeroporto;
import com.aviacao.airdegas.Aviacao.repository.AeroportoRepository;

@RestController
public class AeroportoController {
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@GetMapping("/aeroportos")
	public ArrayList<Aeroporto> listarAeroportos() {
		return (ArrayList<Aeroporto>) aeroportoRepository.findAll();
	}
}
