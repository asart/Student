package com.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.Term;

@Repository
public class TermDAOImpl implements TermDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Term getTerm(Integer id) {
		Term term = (Term) getCurrentSession().get(Term.class, id);
        return term;
	}

	@Override
	public void addTerm(Term term) {
		getCurrentSession().save(term);
	}

	@Override
	public void editTerm(Term term) {
		Term editeTerm = getTerm(term.getId());
		editeTerm.setTermName(term.getTermName());
		editeTerm.setDuration(term.getDuration());
		getCurrentSession().update(editeTerm);
	}

	@Override
	public void deleteTerm(int id) {
		Term term = getTerm(id);
		if (term != null)
			getCurrentSession().delete(term);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Term> listTerm() {
		return getCurrentSession().createQuery("from Term").list();
	}

}
