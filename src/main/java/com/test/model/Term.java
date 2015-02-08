package com.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "term")
public class Term {

	@Id
    @Column(name = "term_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="term")
	private List<Disciplines> discipline;
	
	@Column(name = "term_name")
    private String termName;
	
	@Column(name = "duration")
    private Integer duration;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Disciplines> getDiscipline() {
		return discipline;
	}

	public void setDiscipline(List<Disciplines> discipline) {
		this.discipline = discipline;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
