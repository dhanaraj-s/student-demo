package com.student.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

/**
 * The Class StudentServiceImpl.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;

	/* (non-Javadoc)
	 * @see com.student.service.StudentService#saveStudent(com.student.model.Student)
	 */
	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
		logger.info("saved student data : " + student);
	}

	/* (non-Javadoc)
	 * @see com.student.service.StudentService#viewStudents()
	 */
	@Override
	public List<Student> viewStudents() {
		List<Student> studentList = (List<Student>) studentRepository.findAll();
		logger.info("list of students from DB : " + studentList);
		return studentList;
	}

	/* (non-Javadoc)
	 * @see com.student.service.StudentService#deleteStudent(java.lang.String)
	 */
	@Override
	public void deleteStudent(String id) {
		try{
			studentRepository.delete(id);
		} catch (Exception exception) {
			logger.info("error in delete operation of student id : " + id);
		}
	}

	/* (non-Javadoc)
	 * @see com.student.service.StudentService#getStudent(java.lang.String)
	 */
	@Override
	public Student getStudent(String id) {
		Student studentFromDB = null;
		try{
			studentFromDB = studentRepository.findOne(id);
		} catch (Exception exception) {
			logger.info("student not found, id : " + id);
		}
		return studentFromDB;
	}

}
