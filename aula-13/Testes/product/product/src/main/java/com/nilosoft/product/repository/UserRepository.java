package com.nilosoft.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nilosoft.product.model.Order;
import com.nilosoft.product.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	Page<User> findAll(Pageable pageable);
	Page<User> findByName( Pageable pageable,String name); 
   //  Page<User> findByIsActive(boolean isActive, Pageable pageable);
   //    Page<User> findByTechnicalSkillContaining(String technicalSkill, Pageable pageable);
}
