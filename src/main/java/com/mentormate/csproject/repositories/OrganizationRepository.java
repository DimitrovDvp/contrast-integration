package com.mentormate.csproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentormate.csproject.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
