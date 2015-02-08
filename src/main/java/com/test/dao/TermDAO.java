package com.test.dao;

import java.util.List;

import com.test.model.Term;

public interface TermDAO {
	
	public Term getTerm(Integer id);
	
	public void addTerm(Term term);
	
	public void editTerm(Term term);
	
	public void deleteTerm(int id);
	
	public List<Term> listTerm();

}
