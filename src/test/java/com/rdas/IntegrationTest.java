package com.rdas;

import com.rdas.config.DefaultAppConfiguration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import junit.framework.TestCase;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by rdas on 01/10/2015.
 */
public class IntegrationTest {

    @ClassRule
    public static final DropwizardAppRule<DefaultAppConfiguration> RULE = new DropwizardAppRule<>(StarterApplication.class, "hello-wrld.yml");

    @Test
    public void testGetGreeting() {
        String expected = "Hello world!";
        //Obtain client
        Client client = ClientBuilder.newClient();
        //Build a feature in basic authentication mode
        HttpAuthenticationFeature feature  = HttpAuthenticationFeature.basic("javaeeeee", "crimson");
        //Register the feature
        client.register(feature);
        //Get actual resul string
        String actual = client
                .target("http://localhost:8080/secured_hello")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        //Do an assertion
        assertEquals(expected, actual);

    }


}