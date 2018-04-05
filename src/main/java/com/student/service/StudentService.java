package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;

/**
 * The Interface StudentService.
 */
@Service
public interface StudentService {

	/**
	 * Save student.
	 *
	 * @param student the student
	 */
	public void saveStudent(Student student);

	/**
	 * View students.
	 *
	 * @return the list
	 */
	public List<Student> viewStudents();

	/**
	 * Delete student.
	 *
	 * @param id the id
	 */
	public void deleteStudent(String id);

	/**
	 * Gets the student.
	 *
	 * @param id the id
	 * @return the student
	 */
	public Student getStudent(String id);

}
