package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.dto.LeilaoDTO;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.form.LeilaoFORM;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Leilao;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository.LeilaoRepository;

@RestController
@RequestMapping("/leilao/")
public class LeilaoController {
	 @Autowired
	 private LeilaoRepository leilaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<LeilaoDTO> getLeilaoById(@PathVariable Long id) {
        Optional<Leilao> leilaoOptional = leilaoRepository.findById(id);
        if (leilaoOptional.isPresent()) {
            Leilao leilao = leilaoOptional.get();
            LeilaoDTO leilaoDTO = new LeilaoDTO(leilao.getId(), leilao.getDescricao(), leilao.getValorminimo(), leilao.getStatus());
            return ResponseEntity.ok(leilaoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<LeilaoDTO>> getAllLeiloes() {
        List<Leilao> leiloes = leilaoRepository.findAll();
        List<LeilaoDTO> leilaoDTOs = leiloes.stream()
                .map(leilao -> new LeilaoDTO(leilao.getId(), leilao.getDescricao(), leilao.getValorminimo(), leilao.getStatus()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(leilaoDTOs);
    }
    @PostMapping("/")
    public ResponseEntity<Leilao> criarLeilao(@RequestBody LeilaoFORM leilaoForm, UriComponentsBuilder uriBuilder) {
        Leilao leilao = leilaoForm.criarLeilao();
        leilaoRepository.save(leilao);
        return ResponseEntity.status(HttpStatus.CREATED).body(leilao);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Leilao> atualizarLeilao(@PathVariable Long id, @RequestBody LeilaoFORM leilaoForm) {
        if (!leilaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Leilao leilao = leilaoForm.criarLeilao();
        leilao.setId(id);
        leilaoRepository.save(leilao);
        return ResponseEntity.ok(leilao);
    }
}
