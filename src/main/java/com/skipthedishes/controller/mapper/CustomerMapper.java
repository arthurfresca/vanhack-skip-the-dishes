package com.skipthedishes.controller.mapper;

import com.skipthedishes.datatransferobject.v1.CustomerDTO;
import com.skipthedishes.domainobject.CustomerDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDO makeCustomerDO(CustomerDTO customerDTO) {
        return CustomerDO.CustomerDOBuilder.aCustomerDO()
                .withId(customerDTO.getId())
                .withAddress(customerDTO.getAddress())
                .withIsActive(true)
                .withName(customerDTO.getName())
                .withPassword(customerDTO.getPassword())
                .withEmail(customerDTO.getEmail())
                .build();
    }


    public static CustomerDTO makeCustomerDTO(CustomerDO customerDO) {
        return CustomerDTO.CustomerDTOBuilder.aCustomerDTO()
                .withId(customerDO.getId())
                .withAddress(customerDO.getAddress())
                .withName(customerDO.getName())
                .withPassword(customerDO.getPassword())
                .withEmail(customerDO.getEmail())
                .build();
    }


    public static List<CustomerDTO> makeCustomersDTOList(Collection<CustomerDO> customers) {
        return customers.stream()
            .map(CustomerMapper::makeCustomerDTO)
            .collect(Collectors.toList());
    }
}
