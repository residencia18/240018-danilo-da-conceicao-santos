package com.nilosoft.product.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.javafaker.Faker;
import com.nilosoft.product.model.Category;
import com.nilosoft.product.model.Order;
import com.nilosoft.product.model.Product;
import com.nilosoft.product.model.User;
import com.nilosoft.product.model.enums.OrderStatus;
import com.nilosoft.product.repository.CategoryRepository;
import com.nilosoft.product.repository.OrderRepository;
import com.nilosoft.product.repository.ProductRepository;
import com.nilosoft.product.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		User u1 = new User(null, faker.name().fullName(), faker.internet().emailAddress(), faker.phoneNumber().cellPhone(), faker.internet().password());
		User u2 = new User(null, "faker.name().fullName()", faker.internet().emailAddress(), faker.phoneNumber().cellPhone(), faker.internet().password());
		User u3 = new User(null, "faker.name().fullName()", faker.internet().emailAddress(),faker.phoneNumber().cellPhone(), faker.internet().password());
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat2);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}
