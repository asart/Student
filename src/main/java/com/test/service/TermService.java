package com.test.service;

import java.util.List;

import com.test.model.Term;

public interface TermService {
	
	public Term getTerm(int id);
	
	public void addTerm(Term term);
	
	public void editTerm(Term term);
	
	public void deleteTerm(int id);
	
	public List<Term> listTerm();

}
