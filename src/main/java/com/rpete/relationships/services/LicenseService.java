package com.rpete.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpete.relationships.models.License;
import com.rpete.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	// returns all licenses
	public List<License> allLicenses() {
		return (List<License>) licenseRepository.findAll();
	}
	
	// creates a new license
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	
	// retrieves a license by id
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	// method for updating license from jsp form
	public License update(License l) {
		return licenseRepository.save(l);
	}
	
	// updates a license
	public License updateLicense(Long id, Date expirationDate, String state) {
		License optionalLicense = this.findLicense(id);
		optionalLicense.setExpirationDate(expirationDate);
		optionalLicense.setState(state);
		return licenseRepository.save(optionalLicense);
	}
	
	// deletes a license by id
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
		return;
	}
}
