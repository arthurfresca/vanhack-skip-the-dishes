package com.skipthedishes.service;

import com.skipthedishes.domainobject.CustomerDO;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.InvalidCredentialException;

public interface CustomerService {

    Boolean findByUserAndPass(String user, String pass) throws InvalidCredentialException;

    CustomerDO createOrUpdate(CustomerDO customerDO) throws ConstraintsViolationException;
}
