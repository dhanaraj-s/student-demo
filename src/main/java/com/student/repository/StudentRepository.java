package com.student.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.model.Student;

/**
 * The Interface StudentRepository.
 */
public interface StudentRepository extends CrudRepository <Student, String>{

}
