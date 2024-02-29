package com.aviacao.airdegas.Aviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aviacao.airdegas.Aviacao.controller.dto.AeroportoDTO;
import com.aviacao.airdegas.Aviacao.model.Aeroporto;
import com.aviacao.airdegas.Aviacao.repository.AeroportoRepository;

@RestController
@RequestMapping("/aeroporto/")
public class AeroportoController {
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@GetMapping
	public ArrayList<Aeroporto> listarAeroportos() {
		return (ArrayList<Aeroporto>) aeroportoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AeroportoDTO> listarAeroportos(@PathVariable Long id, UriComponentsBuilder uribuilder) {
		try {
			Aeroporto aeroporto = aeroportoRepository.getReferenceById(id);
			AeroportoDTO aeroportoDTO = new AeroportoDTO(aeroporto.getId(), aeroporto.getIcao(), aeroporto.getNome());
			uribuilder.path("/aeroporto/{id}");
			return ResponseEntity.ok(aeroportoDTO);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
