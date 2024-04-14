package com.danilosoft.Produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilosoft.Produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByDescricao(String descricao);
}
