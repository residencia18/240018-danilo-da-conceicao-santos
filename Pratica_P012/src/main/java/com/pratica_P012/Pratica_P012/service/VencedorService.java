package com.pratica_P012.Pratica_P012.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pratica_P012.Pratica_P012.modelo.Vencedor;
@Service
public class VencedorService {
    private List<Vencedor> vencedores = new ArrayList<>();

    public VencedorService() {
        carregarVencedoresDoCSV();
    }

    private void carregarVencedoresDoCSV() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/csv/pilotos.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // Ignorar a primeira linha (cabeçalho)
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Vencedor vencedor = new Vencedor(dados[0], dados[1], Integer.parseInt(dados[2]));
                vencedores.add(vencedor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Vencedor> listarTodosVencedores() {
        return vencedores;
    }

    public List<Vencedor> listarVencedoresBrasileiros() {
        List<Vencedor> vencedoresBrasileiros = new ArrayList<>();
        for (Vencedor vencedor : vencedores) {
            if (vencedor.getPais().equalsIgnoreCase("Brasil")) {
                vencedoresBrasileiros.add(vencedor);
            }
        }
        return vencedoresBrasileiros;
    }

    public List<Vencedor> listarTop5Vencedores() {
        vencedores.sort((a, b) -> b.getVitorias() - a.getVitorias());
        return vencedores.subList(0, Math.min(vencedores.size(), 5));
    }
    public List<Vencedor> listarTop10Vencedores() {
        vencedores.sort((a, b) -> b.getVitorias() - a.getVitorias());
        return vencedores.subList(0, Math.min(vencedores.size(), 10));
    }
}