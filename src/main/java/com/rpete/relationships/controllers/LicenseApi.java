package com.rpete.relationships.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rpete.relationships.models.License;
import com.rpete.relationships.services.LicenseService;

@RestController
public class LicenseApi {
	private final LicenseService licenseService;
	
	public LicenseApi(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("api/licenses")
	public List<License> index() {
		return licenseService.allLicenses();
	}
	
	@RequestMapping(value="/api/licenses", method=RequestMethod.POST)
    public License create(@RequestParam(value="expirationDate") Date expirationDate, @RequestParam(value="state") String state) {
        License l = new License(expirationDate, state);
        return licenseService.createLicense(l);
    }
    
    @RequestMapping("/api/licenses/{id}")
    public License show(@PathVariable("id") Long id) {
        License l = licenseService.findLicense(id);
        return l;
    }
    
    @RequestMapping(value="/api/licenses/{id}", method=RequestMethod.PUT)
    public License update(@PathVariable("id") Long id, @RequestParam(value="expirationDate") Date expirationDate, @RequestParam(value="state") String state) {
        License l = licenseService.updateLicense(id, expirationDate, state);
        return l;
    }
    
    @RequestMapping(value="/api/licenses/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	licenseService.deleteLicense(id);
    }
}
