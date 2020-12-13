package com.rpete.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpete.relationships.models.License;
import com.rpete.relationships.models.Person;
import com.rpete.relationships.services.LicenseService;
import com.rpete.relationships.services.PersonService;

@Controller
public class LicenseController {
	
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/license")
	public String addLicense(Model model, @ModelAttribute("license") License license){
		List<License> licenses = licenseService.allLicenses();
		List<Person> persons = personService.allPersons();
		model.addAttribute("licenses", licenses);
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	
	@PostMapping("/license/create")
	public String processAddLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
}
