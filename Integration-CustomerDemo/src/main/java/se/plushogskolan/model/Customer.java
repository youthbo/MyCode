package se.plushogskolan.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//JAX-RS support JAXB, JAXB can convert xml to json automatically
//if there is no xml annotations at all here, response will still generate json format
//use json format as default
@XmlRootElement
public class Customer {

	@XmlAttribute
	private Long id;
	@XmlElement
	private String firstname;
	@XmlElement
	private String lastname;
	@XmlElement
	private String number;
	
	//for list
	@XmlElementWrapper(name = "roles")
	@XmlElement
	private List<String> role;
	
	//must have an empty constructor for jaxb
	@SuppressWarnings("unused")
	private Customer(){}
	
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

	
	
	
}
