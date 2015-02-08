package com.test.service;

import java.util.List;

import com.test.model.Disciplines;

public interface DisciplinesService {
	
	public Disciplines getDiscipline(int id);
	
	public void addDiscipline(Disciplines discipline);
	
	public void editDiscipline(Disciplines discipline);
	
	public void deleteDiscipline(int id);
	
	public List<Disciplines> listDiscipline();

}
