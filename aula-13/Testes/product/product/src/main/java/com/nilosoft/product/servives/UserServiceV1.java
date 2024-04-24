package com.nilosoft.product.servives;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.nilosoft.product.model.User;
import com.nilosoft.product.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceV1 {
	@ Autowired
	private UserRepository repository;
	
	
	
	 public List<User> findAllSorted(String[] sort) {
	        List<Order> orders = new ArrayList<>();
	        for (String sortOrder : sort) {
	            String[] _sort = sortOrder.split(",");
	            orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
	        }
	        return repository.findAll(Sort.by(orders));
	    }

	    private Sort.Direction getSortDirection(String direction) {
	        if ("asc".equals(direction)) {
	            return Sort.Direction.ASC;
	        } else if ("desc".equals(direction)) {
	            return Sort.Direction.DESC;
	        }
	        return Sort.Direction.ASC;
	    }
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
	
	public Page<User> listUser(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	@Transactional
	public User save(User user){

	    return repository.save(user);
	}

	@Transactional
	public void delete(Long id){
	    repository.deleteById(id);
	}

	@Transactional
	public User update(Long id, User user){
	    User existingUser = findById(id);
	    if (existingUser == null) {
	        throw new NoSuchElementException("Usuário com id " + id + " não encontrado");
	    }
	    existingUser.setName(user.getName());
	    existingUser.setEmail(user.getEmail());
	    existingUser.setPhone(user.getPhone());
	    existingUser.setPassword(user.getPassword());

	    return repository.save(existingUser);
	}
}
