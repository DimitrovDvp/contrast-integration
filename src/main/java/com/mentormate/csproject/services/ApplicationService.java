package com.mentormate.csproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentormate.csproject.entities.Application;
import com.mentormate.csproject.repositories.ApplicationsRepository;

@Service
public class ApplicationService {
	
	private final ApplicationsRepository applicationRepository;

	@Autowired
	public ApplicationService(ApplicationsRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	public List<Application> getByOrganizationId(Long id) {
		return applicationRepository.findByOrganizationId(id);
	}
}
