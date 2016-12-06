package se.plushogskolan.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//@Provider
public class CustomerExceptionMapper implements ExceptionMapper<InvalidCustomerException>{

	@Override
	public Response toResponse(InvalidCustomerException e) {
		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
	}

}
