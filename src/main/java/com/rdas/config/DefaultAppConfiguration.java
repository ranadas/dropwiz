package com.rdas.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;
import java.sql.Connection;

/**
 * Created by rdas on 01/10/2015.
 */
public class DefaultAppConfiguration extends Configuration {
    /**
     * User login.
     */
    @NotNull
    private String login;
    /**
     * User password.
     */
    @NotNull
    private String password;

    /**
     * Login getter.
     *
     * @return
     */
    @JsonProperty
    public String getLogin() {
        return login;
    }

    /**
     * Password getter.
     *
     * @return
     */
    @JsonProperty
    public String getPassword() {
        return password;
    }
}
