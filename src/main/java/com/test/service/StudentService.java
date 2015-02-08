package com.test.service;

import java.util.List;

import com.test.model.Student;

public interface StudentService {

	public Student getStudent(int id);
	
	public void addStudent(Student student);
	
	public void editStudent(Student student);
	
	public void deleteStudent(int id);
	
	public List<Student> listStudent();
}
