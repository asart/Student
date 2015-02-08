package com.test.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.test.model.Result;
import com.test.model.Student;
import com.test.model.Term;
import com.test.service.DisciplinesService;
import com.test.service.StudentService;
import com.test.service.TermService;

@Controller
@RequestMapping(value="/sistem")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TermService termService;
	
	@Autowired
	private DisciplinesService disciplinesService;
	
	@RequestMapping(value="/list")
	public ModelAndView listOfTeams() {
		
		ModelAndView modelAndView = new ModelAndView("listStudent");

		List<Student> students = studentService.listStudent();
		modelAndView.addObject("students", students);

		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addStudentViev() {
		
		ModelAndView modelAndView = new ModelAndView("addEditStudent");
			modelAndView.addObject("student", new Student());
			
		String message = "Для создания студента заполните все поля и нажмите кнопку применить";
			modelAndView.addObject("message", message);
			
		String addedit = "add";	
		modelAndView.addObject("addedit", addedit);
		
		return modelAndView;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute  @Valid Student student, BindingResult result) {
		
		if (result.hasErrors()){		
			
			   ModelAndView modelAndView = new ModelAndView("addEditStudent");
			   
			   String errormessage = "Поля не должны быть пустыми";
			   		modelAndView.addObject("errormessage", errormessage);
			   		
			   return modelAndView;			   
		}
		else{			
			  ModelAndView modelAndView = new ModelAndView("home");
			  studentService.addStudent(student);
			  return modelAndView;
		}			  
	}
	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editStudentViev(@PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("addEditStudent");
		
		Student student = studentService.getStudent(id);
			modelAndView.addObject("student",student);
			
		String message = "Для модификации, введите новые значения и нажмите кнопку применить";
			modelAndView.addObject("message", message);
			
		String addedit = "edit/"+id;	
			modelAndView.addObject("addedit", addedit);
			
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Student student, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
			studentService.editStudent(student);	
			
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		studentService.deleteStudent(id);
		
		return modelAndView;
	}
	
	private Double averageResult (List<Result> list){
		
		Double average = 0.0;
			for(Result res : list){
				average +=  res.getMark();
			}
		average = average / list.size();
		average = new BigDecimal(average).setScale(1, RoundingMode.UP).doubleValue();
		return average;
	}
	
	@RequestMapping(value="/statistic/{id}", method=RequestMethod.GET)
	public ModelAndView statisticStudentViev(@PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("statisticStudent");
		
		Student student = studentService.getStudent(id);
			modelAndView.addObject("student",student);
			
		List<Term> term = termService.listTerm();		
			modelAndView.addObject("term", term);
		
		List<Disciplines> disciplines = disciplinesService.listDiscipline();
			modelAndView.addObject("disciplines", disciplines);
			
		List<Result> result = student.getResults();
			modelAndView.addObject("result", result);
			
		Double average = averageResult (result);
			modelAndView.addObject("average", average);
			
		String statistic = "statistic/"+id;
			modelAndView.addObject("statistic", statistic );
			
		return modelAndView;
	}
	
}
