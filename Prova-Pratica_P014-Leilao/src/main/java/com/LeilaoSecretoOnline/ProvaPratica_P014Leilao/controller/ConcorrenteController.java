package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.dto.ConcorrenteDTO;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.form.ConcorrenteFORM;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Concorrente;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository.ConcorrenteRepository;


@RestController
@RequestMapping("/concorrente/")
public class ConcorrenteController {
	@Autowired
	private ConcorrenteRepository concorrenteRepository;
	
	@GetMapping("/{id}")
    public ResponseEntity<ConcorrenteDTO> listarConcorrentePorId(@PathVariable Long id) {
        try {
            Concorrente concorrente = concorrenteRepository.findById(id).orElseThrow();
            ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrente.getId(), concorrente.getNome());
            return ResponseEntity.ok(concorrenteDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ConcorrenteDTO>> listarTodosConcorrentes() {
        try {
            List<Concorrente> concorrentes = concorrenteRepository.findAll();
            List<ConcorrenteDTO> concorrenteDTOs = new ArrayList<>();
            for (Concorrente concorrente : concorrentes) {
                concorrenteDTOs.add(new ConcorrenteDTO(concorrente.getId(), concorrente.getNome()));
            }
            return ResponseEntity.ok(concorrenteDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Concorrente> criarConcorrente(@RequestBody ConcorrenteFORM concorrenteForm, UriComponentsBuilder uriBuilder) {
        Concorrente concorrente = concorrenteForm.criarConcorrente();
        concorrenteRepository.save(concorrente);
        return ResponseEntity.status(HttpStatus.CREATED).body(concorrente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concorrente> atualizarConcorrente(@PathVariable Long id, @RequestBody ConcorrenteFORM concorrenteForm) {
        if (!concorrenteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Concorrente concorrente = concorrenteForm.criarConcorrente();
        concorrente.setId(id);
        concorrenteRepository.save(concorrente);
        return ResponseEntity.ok(concorrente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConcorrenteId(@PathVariable Long id) {
        try {
            concorrenteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/")
    public ResponseEntity<Void> excluirConcorrente() {      
    	return ResponseEntity.badRequest().build();
    }  
	
}
