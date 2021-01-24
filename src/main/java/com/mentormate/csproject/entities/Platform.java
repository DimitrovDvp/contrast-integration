package com.mentormate.csproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Platform extends BaseEntity {
	
	@OneToOne(mappedBy = "platform", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
	private Application application;
	
	@Column(name = "name", nullable = false)
	private String name;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
