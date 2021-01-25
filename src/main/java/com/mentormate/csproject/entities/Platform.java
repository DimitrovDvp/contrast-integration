package com.mentormate.csproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Platform extends BaseEntity {
	
	@Column(name = "name", nullable = false)
	private String name;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
