package com.aviacao.airdegas.Aviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviacao.airdegas.Aviacao.model.ModeloAeronave;
import com.aviacao.airdegas.Aviacao.repository.ModeloAeronaveRepository;

@RestController
public class ModeloAeronaveController {
	@Autowired
	private ModeloAeronaveRepository modeloAeronaveRepository;
	
	@GetMapping("/modelos")
	public ArrayList<ModeloAeronave> listarModelosAeronave() {
		return (ArrayList<ModeloAeronave>) modeloAeronaveRepository.findAll();
	}
	
}
