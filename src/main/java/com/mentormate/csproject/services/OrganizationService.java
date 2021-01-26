package com.mentormate.csproject.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentormate.csproject.entities.Organization;
import com.mentormate.csproject.repositories.OrganizationRepository;

@Service
public class OrganizationService {
	
	private final OrganizationRepository organizationRepository;

	@Autowired
	public OrganizationService(OrganizationRepository organizationRepository) {
		this.organizationRepository = organizationRepository;
	}
	
	public List<Organization> getAllOrganizations(){
		return this.organizationRepository.findAll();
	}
	
	public Organization getOrganizationsById(Long id) throws EntityNotFoundException{
		return organizationRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Organization with ID: %d does not exist.", id)));
	}
	
}
