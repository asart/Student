package com.test.dao;

import java.util.List;

import com.test.model.Disciplines;

public interface DisciplinesDAO {
	
	public Disciplines getDiscipline(Integer id);
	
	public void addDiscipline(Disciplines discipline);
	
	public void editDiscipline(Disciplines discipline);
	
	public void deleteDiscipline(int id);
	
	public List<Disciplines> listDiscipline();

}
