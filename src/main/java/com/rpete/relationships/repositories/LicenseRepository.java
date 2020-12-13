package com.rpete.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rpete.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
}
