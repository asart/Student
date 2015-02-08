package com.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.Term;
import com.test.model.Disciplines;
import com.test.service.DisciplinesService;
import com.test.service.TermService;

@Controller
@RequestMapping(value="/termview")
@SessionAttributes
public class TermController {

	@Autowired
	private TermService termService;
	
	@Autowired
	private DisciplinesService disciplinesService;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listOfTerm() {
		
		ModelAndView modelAndView = new ModelAndView("listTerm");
		List<Term> term = termService.listTerm();		
			modelAndView.addObject("term", term);
			
		List<Disciplines> disciplines = disciplinesService.listDiscipline();
			modelAndView.addObject("disciplines", disciplines);
			
		return modelAndView;
	}  
	
@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTermViev() {
		ModelAndView modelAndView = new ModelAndView("addEditTerm");
			modelAndView.addObject("term", new Term());
			
		String message = "Для создания term заполните все поля и нажмите кнопку применить";
		String addedit = "add";
			modelAndView.addObject("message", message);
			modelAndView.addObject("addedit", addedit);
			
		return modelAndView;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTerm(@ModelAttribute Term term) {

		ModelAndView modelAndView = new ModelAndView("home");
			termService.addTerm(term);
			
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTermViev(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("addEditTerm");
		Term term = termService.getTerm(id);
			modelAndView.addObject("term", term);
			
		String message = "Для модификации term заполните все поля и нажмите кнопку применить";
		String addedit = "edit/"+id;
		
			modelAndView.addObject("message", message);
			modelAndView.addObject("addedit", addedit);
			
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingTerm(@ModelAttribute Term term, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		termService.editTerm(term);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTerm(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		
		termService.deleteTerm(id);
		
		return modelAndView;
	}

}
