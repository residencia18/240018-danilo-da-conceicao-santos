package com.nilosoft.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilosoft.product.model.Order;


public interface OrderRepository  extends JpaRepository<Order, Long> {

}
