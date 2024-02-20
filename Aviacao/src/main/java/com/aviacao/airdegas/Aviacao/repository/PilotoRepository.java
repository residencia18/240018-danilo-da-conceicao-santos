package com.aviacao.airdegas.Aviacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviacao.airdegas.Aviacao.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {
	List<Piloto> findByNome(String nome);
}
