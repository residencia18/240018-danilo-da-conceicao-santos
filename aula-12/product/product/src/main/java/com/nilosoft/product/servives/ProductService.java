package com.nilosoft.product.servives;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilosoft.product.model.Product;
import com.nilosoft.product.repository.ProductRepository;

@Service
public class ProductService {
	@ Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	public Product findById(Long id){
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
