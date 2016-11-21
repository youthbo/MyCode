package se.plushogskolan.sdj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String username;

	public User() {
	}

	public User(String firstname, String lastname, String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
}
