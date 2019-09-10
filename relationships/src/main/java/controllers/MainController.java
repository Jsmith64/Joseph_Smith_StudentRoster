package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.License;
import models.Person;
import services.LicenseService;
import services.PersonService;

@Controller
@RequestMapping("/")
public class MainController {
	private final PersonService PersonService;
	private final LicenseService licenseService;
	
	public MainController(PersonService PersonService, LicenseService licenseService) {
		this.PersonService = PersonService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<Person> Persons = PersonService.getAllPersons();
		model.addAttribute("Persons", Persons);
		return "index.jsp";
	}
	@RequestMapping("/persons/new")
	public String showAddPerson(@ModelAttribute("Person") Person Person) {
		return "add.jsp";
	}
	@PostMapping("/persons/new")
	public String AddPerson(@Valid @ModelAttribute("Person") Person Person, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/persons/new";
		} else {
			PersonService.addPerson(Person);
			return "redirect:/";
		}
	}
	@RequestMapping("/licenses/new")
	public String showAddLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> Persons = PersonService.getAllPersons();
		model.addAttribute("Persons", Persons);
		return "addlicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, RedirectAttributes errors) {
		System.out.println(license.getExpirationDate());
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/licenses/new";
		} else {
			licenseService.addLicense(license);
			return "redirect:/";
		}
	}
	@RequestMapping("/persons/{id}")
	public String showOnePersonLicense(Model model, @PathVariable("id") Long id) {
		Person Person = PersonService.getPersonById(id);
		if(Person == null) {
			return "redirect:/";
		}
		model.addAttribute("Person", Person);
		return "showlicense.jsp";
	}
	@RequestMapping("persons/{PersonId}/delete")
	public String deletePerson(@PathVariable("PersonId") Long PersonId) {
		PersonService.deletePerson(PersonId);
		return "redirect:/";
	}
}
