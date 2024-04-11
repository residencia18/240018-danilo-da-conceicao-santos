package com.nilosoft.product.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilosoft.product.model.Product;
import com.nilosoft.product.servives.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> FindAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
