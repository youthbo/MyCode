package se.plushogskolan.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import se.plushogskolan.resource.CustomerExceptionMapper;
import se.plushogskolan.resource.CustomerResource;

@Component
//@ApplicationPath("bo")
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		        register(CustomerResource.class);
		        register(CustomerExceptionMapper.class);
		    }

}
