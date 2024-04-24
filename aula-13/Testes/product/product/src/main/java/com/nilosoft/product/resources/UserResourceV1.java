package com.nilosoft.product.resources;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nilosoft.product.model.User;
import com.nilosoft.product.servives.UserServiceV1;

@RestController
@RequestMapping("/v1/users")
public class UserResourceV1 {
	@Autowired
	private UserServiceV1 service;
	
	
	@GetMapping("/sorteusers")
    public ResponseEntity<List<User>> getAllEmployees(@RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<User> employees = service.findAllSorted(sort);
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping(value = "/{all}")
	public ResponseEntity<List<User>> FindAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping
//	public List<User> listUser(Pageable pageable) {
//		
//		return service.listUser(pageable).getContent();
//	}
	 @GetMapping
	    public ResponseEntity<Page<User>> getAllEmployees(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        Page<User> employeePage = service.findAll(PageRequest.of(page, size));
	        if (employeePage.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(employeePage, HttpStatus.OK);
	    }
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> create(@RequestBody User user) {
	    User createdUser = service.save(user);
	    return ResponseEntity.ok().body(createdUser);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
	    User updatedUser = service.update(id, user);
	    return ResponseEntity.ok().body(updatedUser);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
	    service.delete(id);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
