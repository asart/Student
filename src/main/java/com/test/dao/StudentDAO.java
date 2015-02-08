package com.test.dao;

import java.util.List;
import com.test.model.Student;

public interface StudentDAO {
	
	public Student getStudent(Integer id);
	
	public void addStudent(Student student);
	
	public void editStudent(Student student);
	
	public void deleteStudent(int id);
	
	public List<Student> listStudent();
}
