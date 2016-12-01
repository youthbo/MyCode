package se.plushogskolan.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.plushogskolan.model.Customer;
import se.plushogskolan.model.PageRequestBean;

import static se.plushogskolan.model.CustomerParser.*;

import java.util.List;

import se.plushogskolan.service.CustomerService;

@Component
@Path("customers")
public class CustomerResource {
	
	@Autowired
    private CustomerService customerService;
	
	@POST
	public Response create(String value){
		Customer customer = parseToCustomer(value);
		customerService.createCustomer(customer);
		return Response.status(Status.CREATED).header("Location", "customers/"+customer.getId()).build();
		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@PathParam("id")Long id){
		Customer customer = customerService.get(id);
		if (customer==null)
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(parseToString(customer)).build();	
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getXML(@PathParam("id")Long id){
		Customer customer = customerService.get(id);
		if (customer==null)
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(parseToXml(customer)).build();	
	}
	
	@GET
	public Response getAll(@BeanParam PageRequestBean pageRequest){
		List<Customer> result = customerService.getCustomers(pageRequest.getPage(),
				                   pageRequest.getSize(),pageRequest.getSort());
		StringBuilder resultString = new StringBuilder();
		result.forEach(c->{resultString.append(parseToString(c));
		                   resultString.append("/n");});
		return Response.ok(resultString.toString()).build();
		
	}
}
