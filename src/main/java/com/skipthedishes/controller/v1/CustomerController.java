package com.skipthedishes.controller.v1;

import com.skipthedishes.controller.mapper.CustomerMapper;
import com.skipthedishes.datatransferobject.v1.AuthDTO;
import com.skipthedishes.datatransferobject.v1.CustomerDTO;
import com.skipthedishes.domainobject.CustomerDO;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.service.AuthenticateService;
import com.skipthedishes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * All operations with a customer will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("api/v1/Customer")
public class CustomerController {

    private final AuthenticateService authenticateService;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(AuthenticateService authenticateService, CustomerService customerService) {
        this.authenticateService = authenticateService;
        this.customerService = customerService;
    }

    @PostMapping("/auth")
    public String authUser(@Valid @RequestBody AuthDTO AuthDTO) {
        return "";
    }

    @PostMapping
    public CustomerDTO createUpdateCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws ConstraintsViolationException {
        CustomerDO customerDO = CustomerMapper.makeCustomerDO(customerDTO);
        return CustomerMapper.makeCustomerDTO(customerService.createOrUpdate(customerDO));
    }
}
