package com.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addStudent(Student student){
		getCurrentSession().save(student);
	}
	
	@Override
	public Student getStudent(Integer id) {
		Student student = (Student) getCurrentSession().get(Student.class, id);
        return student;
	}
	
	@Override
	public void editStudent(Student student){
		Student editStudent = getStudent(student.getId());
		editStudent.setName(student.getSurname());
		editStudent.setName(student.getName());		
		editStudent.setName(student.getGroup());
		editStudent.setName(student.getDateIn());
		getCurrentSession().update(editStudent);
	}
	
	@Override
	public void deleteStudent(int id){
		Student student = getStudent(id);
		if (student != null)
			getCurrentSession().delete(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
	    return getCurrentSession().createQuery("from Student").list();
	}
}
