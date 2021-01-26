package com.mentormate.csproject.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentormate.csproject.entities.Application;
import com.mentormate.csproject.entities.Organization;
import com.mentormate.csproject.services.ApplicationService;
import com.mentormate.csproject.services.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
	
	private final OrganizationService organizationService;
	private final ApplicationService applicationService;
	
	@Autowired
	public OrganizationController(OrganizationService organizationService, ApplicationService applicationService) {
		this.organizationService = organizationService;
		this.applicationService = applicationService;
	}
	
	@GetMapping
    public ResponseEntity<List<Organization>> getAll() {
		return new ResponseEntity<>(this.organizationService.getAllOrganizations(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Organization> getById(@PathVariable("id") Long id) throws EntityNotFoundException {
		return new ResponseEntity<>(this.organizationService.getOrganizationsById(id), HttpStatus.OK);
	}
    
	@GetMapping("/{id}/applications")
    public ResponseEntity<List<Application>> getApplications(@PathVariable("id") Long id,
    		@RequestParam(required = false) String name,
    		@RequestParam(required = false) String order) {
		
		return new ResponseEntity<>(this.applicationService.getByOrganizationId(id, name, order), HttpStatus.OK);
	}
    
}
