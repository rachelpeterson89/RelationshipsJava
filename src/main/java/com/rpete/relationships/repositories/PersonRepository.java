package com.rpete.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rpete.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
}
