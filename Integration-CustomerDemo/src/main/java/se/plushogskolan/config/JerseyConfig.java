package se.plushogskolan.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import se.plushogskolan.resource.CustomerResource;


@Configuration
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		        register(CustomerResource.class);
		    }

}
