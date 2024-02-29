package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {
    @Query("SELECT l FROM Lance l WHERE l.leilao.id = :leilaoId AND l.valor = (SELECT MAX(l2.valor) FROM Lance l2 WHERE l2.leilao.id = :leilaoId)")
    Optional<Lance> findMaxLanceByLeilao(@Param("leilaoId") Long leilaoId);
}
