package com.mentormate.csproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mentormate.csproject.entities.Application;
import com.mentormate.csproject.repositories.ApplicationsRepository;

@Service
public class ApplicationService {
	
	private final ApplicationsRepository applicationRepository;

	@Autowired
	public ApplicationService(ApplicationsRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	/**
	 * Method retrieves Applications by @id and: @name, @orderQuery if provided
	 *  
	 * @param id application's organizationId
	 * @param name part of application's name
	 * @param orderQuery should follow the pattern: 'name asc' - '{column to order on}{asc|desc}'
	 * @return List<Application>
	 */
	public List<Application> getByOrganizationId(Long id, String name, String orderQuery){
		if(!ObjectUtils.isEmpty(orderQuery)) {
			final String orderQuerySeparator = " ";
			String[] orderQueryItems = orderQuery.replace("'", "").split(orderQuerySeparator);
			String orderColumnName = orderQueryItems[0];
			String orderDirection = orderQueryItems[1];
			
			return applicationRepository.findByOrganizationIdAndNameContainingIgnoreCase(id, name, Sort.by(Sort.Direction.fromString(orderDirection), orderColumnName));
		
		} else if (!ObjectUtils.isEmpty(name)) {
			return applicationRepository.findByOrganizationIdAndNameContainingIgnoreCase(id, name);
		
		} else {
			return applicationRepository.findByOrganizationId(id);
		}
	}
}
