package com.nilosoft.product.servives;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilosoft.product.model.User;
import com.nilosoft.product.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@ Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
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
	    if (!repository.existsById(id)) {
	        throw new NoSuchElementException("Usuário com id " + id + " não encontrado");
	    }
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
