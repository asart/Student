package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.DisciplinesDAO;
import com.test.model.Disciplines;

@Service
@Transactional
public class DisciplinesServiceImpl implements DisciplinesService {
	
	@Autowired
	DisciplinesDAO disciplinesDAO;

	@Override
	public Disciplines getDiscipline(int id) {
		return disciplinesDAO.getDiscipline(id);
	}

	@Override
	public void addDiscipline(Disciplines discipline) {
		disciplinesDAO.addDiscipline(discipline);
	}

	@Override
	public void editDiscipline(Disciplines discipline) {
		disciplinesDAO.editDiscipline(discipline);
	}

	@Override
	public void deleteDiscipline(int id) {
		disciplinesDAO.deleteDiscipline(id);
	}

	@Override
	public List<Disciplines> listDiscipline() {
		return disciplinesDAO.listDiscipline();
	}

}
