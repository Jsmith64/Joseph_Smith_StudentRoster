package services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import models.License;
import models.Person;
import repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository PersonRepository;
	private PersonService(PersonRepository PersonRepository) {
		this.PersonRepository = PersonRepository;
	}
	public void addPerson(Person person) {
		PersonRepository.save(person);
	}
	public List<Person> getAllPersons(){
		return (List<Person>) PersonRepository.findAll();
	}
	public void deletePerson(Long id) {
		PersonRepository.deleteById(id);
	}
	public Person getPersonById(Long id) {
		return PersonRepository.findById(id);
	}
}
