package com.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.Disciplines;

@Repository
public class DisciplinesDAOImpl implements DisciplinesDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Disciplines getDiscipline(Integer id) {
		Disciplines discipline = (Disciplines) getCurrentSession().get(Disciplines.class, id);
        return discipline;
	}

	@Override
	public void addDiscipline(Disciplines discipline) {
		getCurrentSession().save(discipline);
	}

	@Override
	public void editDiscipline(Disciplines discipline) {
		Disciplines editeDiscipline = getDiscipline(discipline.getId());
		editeDiscipline.setSubject(discipline.getSubject());
		getCurrentSession().update(editeDiscipline);
	}

	@Override
	public void deleteDiscipline(int id) {
		Disciplines discipline = getDiscipline(id);
		if (discipline != null)
			getCurrentSession().delete(discipline);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplines> listDiscipline() {
		return getCurrentSession().createQuery("from Disciplines").list();
	}

}
