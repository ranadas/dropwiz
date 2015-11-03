package com.rdas.auth;

import com.google.common.base.Optional;
import com.rdas.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;


/**
 * Created by rdas on 01/10/2015.
 */
public class GreetingAuthenticator implements Authenticator<BasicCredentials, User> {

    /**
     * User login.
     */
    private String login;
    /**
     * User password.
     */
    private String password;

    /**
     * Constructor.
     *
     * @param login    user-ID
     * @param password password
     */
    public GreetingAuthenticator(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * The method authenticate users.
     *
     * @param credentials user credentials, in this case login and password.
     * @return Optional containing User if present and empty if absent.
     * @throws AuthenticationException
     */
    @Override
    public Optional<User> authenticate(BasicCredentials credentials)
            throws AuthenticationException {
        if (password.equals(credentials.getPassword())
                && login.equals(credentials.getUsername())) {
            return Optional.of(new User());
        } else {
            return Optional.absent();
        }
    }
}
