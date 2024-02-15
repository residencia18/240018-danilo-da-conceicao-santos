package com.pratica_P012.Pratica_P012.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica_P012.Pratica_P012.modelo.Vencedor;
import com.pratica_P012.Pratica_P012.service.VencedorService;

@RestController
public class VencedorController {

    @Autowired
    private VencedorService servicoVencedor;

    @GetMapping("/todos")
    public List<Vencedor> listarTodosVencedores() {
        return servicoVencedor.listarTodosVencedores();
    }

    @GetMapping("/brasileiros")
    public List<Vencedor> listarVencedoresBrasileiros() {
        return servicoVencedor.listarVencedoresBrasileiros();
    }

    @GetMapping("/top5")
    public List<Vencedor> listarTop5Vencedores() {
        return servicoVencedor.listarTop5Vencedores();
    }
}