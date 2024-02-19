package com.degasoft.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.degasoft.redesocial.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
