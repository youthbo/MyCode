package se.plushogskolan.resource;

import static se.plushogskolan.model.CustomerParser.parseToCustomer;
import static se.plushogskolan.model.CustomerParser.parseToString;
import static se.plushogskolan.model.CustomerParser.parseToXml;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.plushogskolan.model.Customer;
import se.plushogskolan.model.PageRequestBean;
import se.plushogskolan.service.CustomerService;

@Component
@Path("customers")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class CustomerResource {
	
	@Autowired
    private CustomerService customerService;
	@Context
	private UriInfo uriInfo;
	
	//one way to get header 
	@Context
	private HttpHeaders headers;
	//another way to get header
	//private @HeaderParam("api-key") String key;
	
	@GET
	@Path("header")
	public Response getKey(){
		String key = headers.getHeaderString("api-key");
		return Response.ok(key).build();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response add(String value){
		//test with header
//		String key = headers.getHeaderString("api-key");
//		if (key==null){
//			throw new WebApplicationException("api-key missed in header", Response.status(Status.BAD_REQUEST).build());
//		}
		Customer customer = parseToCustomer(value);
		customerService.createCustomer(customer);
		return Response.status(Status.CREATED).header("Location", "customers/"+customer.getId()).build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Customer customer){
		customerService.createCustomer(customer);
		URI location = uriInfo.getAbsolutePathBuilder().path(CustomerResource.class, "getXML").build(customer.getId());
		return Response.created(location).build();
	}
	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@PathParam("id")String id) throws InvalidCustomerException {
		Long longId = null;
		try{
			longId = Long.parseLong(id);
		}catch(NumberFormatException e){
			// use jax-rs webApplicationException
			//throw new InvalidCustomerException(id+"is a bad request.");
			
			//when use java exception,need ExceptionMapper to map it to Response
			throw new InvalidCustomerException(id+" is a bad request.");		
		}
		Customer customer = customerService.get(longId);
		if (customer==null)
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(parseToString(customer)).build();	
	}
	/*
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getXML(@PathParam("id")Long id){
		Customer customer = customerService.get(id);
		return Response.ok(parseToXml(customer)).build();
		
	}*/
	
	@GET
	@Path("{id}")
	public Customer getXML(@PathParam("id")Long id){
		Customer customer = customerService.get(id);
		return customer;	//works if there is xml annotation in Customer object
	}
	 
	/*
	@GET	
	public Response getAll(@BeanParam PageRequestBean pageRequest){
		List<Customer> result = customerService.getCustomers(pageRequest.getPage(),
				                   pageRequest.getSize(),pageRequest.getSort());
	    GenericEntity<List<Customer>> entity = new GenericEntity<List<Customer>>(){};
		return Response.ok(entity).build();
	}
	*/
	
	@GET	
	public Collection<Customer> getAll(@BeanParam PageRequestBean pageRequest){
		List<Customer> result = customerService.getCustomers(pageRequest.getPage(),
				                   pageRequest.getSize(),pageRequest.getSort());	
		return result;
	}
	
	@GET
	@Path("URLs")
	public Response getAllCustomersURL(){
		List<Customer> customers = customerService.getCustomers();
		StringBuilder result= new StringBuilder();
		for(Customer customer:customers){
			result.append((uriInfo.getAbsolutePathBuilder()
					   .path(CustomerResource.class, "getXML").build(customer.getId()).toString()));
		    result.append("\n");
		}
		return Response.ok(result.toString()).build();
	}
}
