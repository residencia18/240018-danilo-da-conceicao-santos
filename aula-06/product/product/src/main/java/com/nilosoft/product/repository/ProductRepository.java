package com.nilosoft.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilosoft.product.model.Order;
import com.nilosoft.product.model.Product;
import com.nilosoft.product.model.User;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
