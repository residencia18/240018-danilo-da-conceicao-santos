package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Lance;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Leilao;

public interface LanceRepository extends JpaRepository<Lance, Long> {
	@Query("SELECT l FROM Lance l WHERE l.leilao = :leilao ORDER BY l.valor DESC")
	Optional<Lance> findByLeilaoOrderByValorDesc(@Param("leilao") Leilao  leilao );
}
