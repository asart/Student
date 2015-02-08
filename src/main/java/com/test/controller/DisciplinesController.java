package com.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.Disciplines;
import com.test.service.DisciplinesService;

@Controller
@RequestMapping(value="/disciplines")
public class DisciplinesController {
	
	@Autowired
	private DisciplinesService disciplinesService;
	
	@RequestMapping(value="/list")
	public ModelAndView listOfDisciplines() {
		
		ModelAndView modelAndView = new ModelAndView("listDisciplines");

		List<Disciplines> disciplines = disciplinesService.listDiscipline();
			modelAndView.addObject("disciplines", disciplines);

		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addDisciplinesViev() {
		
		ModelAndView modelAndView = new ModelAndView("addEditDisciplines");
			modelAndView.addObject("disciplines", new Disciplines());
			
		String message = "Для создания дисциплины заполните все поля и нажмите кнопку применить";
			modelAndView.addObject("message", message);
			
		String addedit = "add";		
		modelAndView.addObject("addedit", addedit);
		
		return modelAndView;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingDisciplines(@ModelAttribute @Valid Disciplines disciplines, BindingResult result) {

		if (result.hasErrors()){		
			
			   ModelAndView modelAndView = new ModelAndView("addEditDisciplines");
			   
			   String errormessage = "Поля не должны быть пустыми";
			   		modelAndView.addObject("errormessage", errormessage);
			   		
			   return modelAndView;			   
		}
		else{	
		ModelAndView modelAndView = new ModelAndView("home");
			disciplinesService.addDiscipline(disciplines);
			
		return modelAndView;
		}
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editDisciplinesViev(@PathVariable Integer id) 
	{
		ModelAndView modelAndView = new ModelAndView("addEditDisciplines");
		
		Disciplines disciplines = disciplinesService.getDiscipline(id);
			modelAndView.addObject("disciplines",disciplines);
			
		String message = "Для модификации дисциплины заполните все поля и нажмите кнопку применить";
			modelAndView.addObject("message", message);
			
		String addedit = "edit/"+id;		
		modelAndView.addObject("addedit", addedit);
		
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingDisciplines(@ModelAttribute Disciplines disciplines, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
			disciplinesService.editDiscipline(disciplines);
			
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteDiscipline(@PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
			disciplinesService.deleteDiscipline(id);
			
		return modelAndView;
	}

}
