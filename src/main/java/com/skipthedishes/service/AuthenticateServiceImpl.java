package com.skipthedishes.service;

import com.skipthedishes.exception.InvalidCredentialException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to authenticate user.
 * It was used a basic authentication.
 * To log-in you must generate a token by providing some customer credential.
 * You can use some software like Postman for it.
 */
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private CustomerService customerService;

    @Autowired
    public AuthenticateServiceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Method to check if token is valid
     *
     * @param token authentication token
     * @throws InvalidCredentialException if no user with the given credential was found.
     */

    @Override
    public void authenticateToken(String token) throws InvalidCredentialException {
        validateAuthenticationPhrase(token);
    }


    private Boolean validateAuthenticationPhrase(String token) throws InvalidCredentialException {

        byte[] e = Base64.decodeBase64(token.substring(6));
        String usernpass = new String(e);
        String user = usernpass.substring(0, usernpass.indexOf(':'));
        String password = usernpass.substring(usernpass.indexOf(':') + 1);
        return customerService.findByUserAndPass(user, password);
    }
}
