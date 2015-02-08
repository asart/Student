package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.StudentDAO;
import com.test.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}
	
	@Override
	public void editStudent(Student student){
		studentDAO.editStudent(student);
	}
	
	@Override
	public void addStudent(Student student){
		studentDAO.addStudent(student);
	}
	
	@Override
	public void deleteStudent(int id){
		studentDAO.deleteStudent(id);
	}

	@Override
	public List<Student> listStudent() {
		return studentDAO.listStudent();
	}

}
