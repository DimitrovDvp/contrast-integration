package com.mentormate.csproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Application extends BaseEntity {
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
    
}
