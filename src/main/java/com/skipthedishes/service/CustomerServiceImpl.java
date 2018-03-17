package com.skipthedishes.service;

import com.skipthedishes.dataaccessobject.CustomerRepository;
import com.skipthedishes.domainobject.CustomerDO;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.InvalidCredentialException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public CustomerServiceImpl (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Boolean findByUserAndPass(String user, String pass) throws InvalidCredentialException {
        if (customerRepository.findExisting(user, pass).isEmpty()) {
            throw new InvalidCredentialException("User doesn't not exists or password is invalid");
        }
        return true;
    }

    @Override
    public CustomerDO createOrUpdate(CustomerDO customerDO) throws ConstraintsViolationException {
        try {
            customerDO.setActive(true);
            customerRepository.save(customerDO);
        }
        catch (DataIntegrityViolationException e) {
            LOG.warn("Some constraints are thrown due to order creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return customerDO;
    }
}
