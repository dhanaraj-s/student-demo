package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

/**
 * The Class StudentController.
 */
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	/**
	 * Adds the student.
	 * 
	 * @param student
	 *            the student
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "success";
	}

	/**
	 * View student.
	 * 
	 * @return the list
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public List<Student> viewStudent() {
		return studentService.viewStudents();
	}

	/**
	 * Delete student.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public List<Student> deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
		return studentService.viewStudents();
	}

	/**
	 * Update student.
	 * 
	 * @param id
	 *            the id
	 * @param student
	 *            the student
	 * @return the list
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public List<Student> updateStudent(@PathVariable String id,
			@RequestBody Student student) {
		Student studentFromDB = studentService.getStudent(id);
		if(null != studentFromDB) {
			studentFromDB.setAge(student.getAge());
			studentFromDB.setName(student.getName());
			studentService.saveStudent(student);
		}
		return studentService.viewStudents();
	}
}
