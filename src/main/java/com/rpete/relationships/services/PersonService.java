package com.rpete.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpete.relationships.models.Person;
import com.rpete.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// returns all persons
	public List<Person> allPersons() {
		return (List<Person>) personRepository.findAll();
	}
	
	// creates a new person
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	// retrieves a person by id
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	// method for updating person from jsp form
	public Person update(Person p) {
		return personRepository.save(p);
	}
	
	// updates a person
	public Person updatePerson(Long id, String first_name, String last_name) {
		Person optionalPerson = this.findPerson(id);
		optionalPerson.setFirstName(first_name);
		optionalPerson.setLastName(last_name);
		return personRepository.save(optionalPerson);
	}
	
	// deletes a person by id
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
		return;
	}
}
