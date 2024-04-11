package com.danilosoft.Produto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.danilosoft.Produto.model.Cliente;
import com.danilosoft.Produto.model.Produto;
import com.danilosoft.Produto.model.Usuario;
import com.danilosoft.Produto.repository.ProdutoRepository;
import com.danilosoft.Produto.repository.UsuarioRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.math.BigDecimal;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	 private UsuarioRepository usuariRepository;
	@Autowired
	 private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		Usuario u1 = new Usuario(null, faker.name().fullName(), faker.internet().emailAddress(), faker.internet().password());
		Usuario u2 = new Usuario(null, faker.name().fullName(), faker.internet().emailAddress(), faker.internet().password());
		Usuario u3 = new Usuario(null, faker.name().fullName(), faker.internet().emailAddress(), faker.internet().password());
		usuariRepository.saveAll(Arrays.asList(u1, u2, u3));
			
		 Produto p1 = new Produto();
	        p1.setId(null);
	        p1.setDescricao(faker.commerce().productName());
	        p1.setPrecoCusto(roundToTwoDecimals(faker.number().randomDouble(2, 1, 1000)));
	        p1.setPrecoVista(roundToTwoDecimals(faker.number().randomDouble(2, 1, 1000)));
	        p1.setPrecoPrazo(roundToTwoDecimals(faker.number().randomDouble(2, 1, 1000)));
	        p1.setQuantidade(faker.number().numberBetween(1, 100));
	        
	        Produto p2 = new Produto();
	        p2.setId(null);
	        p2.setDescricao(faker.commerce().productName());
	        p2.setPrecoCusto(roundToTwoDecimals(faker.number().randomDouble(2, 1, 1000)));
	        p2.setPrecoVista(roundToTwoDecimals(faker.number().randomDouble(2, 1, 1000)));
	        p2.setPrecoPrazo(roundToTwoDecimals(faker.number().randomDouble(2, 1, 1000)));
	        p2.setQuantidade(faker.number().numberBetween(1, 100));    
	        
	        produtoRepository.saveAll(Arrays.asList(p1, p2));
	        
//	    	private Long id;
//	    	private String nome;
//	    	private String Endereco;
//	    	private String numero;
//	    	private String celular;
//	    	private String cidae;
//	    	private String bairro;
//	    	private String cpf;
//	    	private String mais_informacao;
	    Cliente c1 = new Cliente(); 
	    	c1.setId(null);
	    	c1.setNome(faker.name().fullName());
	    	c1.setEndereco(faker.address().fullAddress());
	    	c1.setNumero(faker.numerify("##########"));
	    	c1.setCelular(faker.phoneNumber().cellPhone());
	    	c1.setCidade( faker.address().city());
	    	c1.setBairro(faker.address().streetName());
	    	FakeValuesService fakeValuesService = new FakeValuesService(new java.util.Locale("pt-BR"), new RandomService());      
	    		c1.setCpf(fakeValuesService.regexify("faker.cpf"));
	        c1.setMais_informacao(null);
	        c1.setUsuario(u1);
	}
	 private static double roundToTwoDecimals(double value) {
	        BigDecimal bd = new BigDecimal(Double.toString(value));
	        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
	        return bd.doubleValue();
	    }
}
