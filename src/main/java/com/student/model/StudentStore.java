package com.student.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class StudentStore.
 */
public class StudentStore {

	/** The instance. */
	private static StudentStore instance;
	
	/** The student map. */
	private static List<Student> studentList = new LinkedList<Student>();
	
	/**
	 * Instantiates a new student store.
	 */
	private StudentStore(){}
	
	/**
	 * Gets the single instance of StudentStore.
	 *
	 * @return single instance of StudentStore
	 */
	public static StudentStore getInstance(){
        if(instance == null){
            instance = new StudentStore();
        }
        return instance;
    }
	

	/**
	 * Gets the student list.
	 *
	 * @return the student list
	 */
	public List<Student> getStudentList() {
		return studentList;
	}
}
