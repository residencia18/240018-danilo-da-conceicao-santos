package com.danilosoft.Produto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.danilosoft.Produto.model.Usuario;
import com.danilosoft.Produto.repository.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	 private UsuarioRepository usuariRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@.com", "988888888");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@.com", "977777777");
		Usuario u3 = new Usuario(null, "Bob Brown", "bob@.com", "966666666");
		usuariRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}

}
