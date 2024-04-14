package com.nilosoft.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilosoft.product.model.Order;
import com.nilosoft.product.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {

}
