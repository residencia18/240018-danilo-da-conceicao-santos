package com.danilo.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilo.crudspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
