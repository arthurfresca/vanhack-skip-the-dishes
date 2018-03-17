package com.skipthedishes.service;


import com.skipthedishes.exception.InvalidCredentialException;

public interface AuthenticateService {

    void authenticateToken(String token) throws InvalidCredentialException;

}
