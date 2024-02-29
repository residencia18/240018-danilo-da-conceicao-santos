package com.danilo.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilo.crudspring.model.Course;
import com.danilo.crudspring.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	private final CourseRepository courseRepository;
	
	
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	
	
	
	
	@GetMapping
	public List<Course>list(){		
		return courseRepository.findAll();
	}
}
