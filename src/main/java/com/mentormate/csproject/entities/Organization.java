package com.mentormate.csproject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Organization extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(
	        mappedBy = "organization",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Application> application = new ArrayList<>();
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}
}
