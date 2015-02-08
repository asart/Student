package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TermDAO;
import com.test.model.Term;

@Service
@Transactional
public class TermServiceImpl implements TermService {

	@Autowired
	TermDAO termDAO;
	
	@Override
	public Term getTerm(int id) {
		return termDAO.getTerm(id);
	}

	@Override
	public void addTerm(Term term) {
		termDAO.addTerm(term);
	}

	@Override
	public void editTerm(Term term) {
		termDAO.editTerm(term);
	}

	@Override
	public void deleteTerm(int id) {
		termDAO.deleteTerm(id);
	}

	@Override
	public List<Term> listTerm() {
		return termDAO.listTerm();
	}

}
