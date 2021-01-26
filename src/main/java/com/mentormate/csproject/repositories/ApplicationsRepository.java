package com.mentormate.csproject.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentormate.csproject.entities.Application;

@Repository
public interface ApplicationsRepository extends JpaRepository<Application, Long> {
	List<Application> findByOrganizationId(Long id);
	
	List<Application> findByOrganizationIdAndNameContainingIgnoreCase(Long id, String name);
	
	List<Application> findByOrganizationIdAndNameContainingIgnoreCase(Long id, String name, Sort sort);

}
