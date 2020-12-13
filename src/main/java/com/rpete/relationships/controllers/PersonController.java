package com.rpete.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.rpete.relationships.models.Person;
import com.rpete.relationships.models.License;
import com.rpete.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("person") Person person, @ModelAttribute("license") License license) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "index.jsp";
	}
	
	@RequestMapping("/person")
	public String addPerson(Model model, @ModelAttribute("person") Person person) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/person/create", method=RequestMethod.POST)
	public String processAddPerson(@Valid @ModelAttribute("person") Person person, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			model.addAttribute("person", new Person());
			personService.createPerson(person);
			return "redirect:/person";
		}
	}
	
	@RequestMapping("/person/{id}")
	public String showOnePerson(@PathVariable("id") Long id, Model model) {
		Person onePerson = personService.findPerson(id);
		model.addAttribute("person", onePerson);
		return "showPerson.jsp";
	}
}
