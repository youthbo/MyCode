package se.plushogskolan.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private Long id;
	private String firstname;
	private String lastname;
	private String number;
	
	public Customer(){}
	
	public Customer(Long id, String firstname, String lastname, String number) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
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

	public String getNumber() {
		return number;
	}

	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@XmlElement
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@XmlElement
	public void setNumber(String number) {
		this.number = number;
	}

	
}
