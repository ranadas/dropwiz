package com.rdas.resources;

import com.rdas.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rdas on 01/10/2015.
 */
@Path("secured_hello")
public class SecuredHelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@Auth User user) {
        return "Hello world!";
    }
}
