package com.mentormate.csproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Application extends BaseEntity {
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;
	
	private long organizationId;
	
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

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
    
}
