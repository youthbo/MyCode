package se.plushogskolan.resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

//Extends jax-rs WebApplicationException
//public class InvalidCustomerException extends WebApplicationException {
public class InvalidCustomerException extends Exception {
	private static final long serialVersionUID = -5257781786725885035L;
	
	public InvalidCustomerException(String message){
		//super(message, Status.BAD_REQUEST);
		super(message);
	}

}
