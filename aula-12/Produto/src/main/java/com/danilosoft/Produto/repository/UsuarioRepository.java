package com.danilosoft.Produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilosoft.Produto.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByNome(String nome);
}