package com.rdas;

import com.rdas.auth.GreetingAuthenticator;
import com.rdas.config.DefaultAppConfiguration;
import com.rdas.core.User;
import com.rdas.resources.HelloResource;
import com.rdas.resources.SecuredHelloResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by rdas on 01/10/2015.
 */
public class StarterApplication extends Application<DefaultAppConfiguration> {

    public static void main(final String[] args) throws Exception {
        new StarterApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizzGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<DefaultAppConfiguration> bootstrap) {
        // TODO: application initialization
    }


    @Override
    public void run(DefaultAppConfiguration defaultAppConfiguration, Environment environment) throws Exception {
        environment.jersey().register(AuthFactory.binder(
                new BasicAuthFactory<>(
                        new GreetingAuthenticator(defaultAppConfiguration.getLogin(),
                                defaultAppConfiguration.getPassword()),
                        "SECURITY REALM",
                        User.class)));
        environment.jersey().register(new HelloResource());
        environment.jersey().register(new SecuredHelloResource());
    }
}
