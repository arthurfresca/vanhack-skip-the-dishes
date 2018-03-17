package com.skipthedishes.datatransferobject.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

    private long id;

    @NotNull(message = "Email can not be null!")
    private String email;

    @NotNull(message = "Name can not be null!")
    private String name;

    @NotNull(message = "Address can not be null!")
    private String address;

    private Date creation;

    @NotNull(message = "Password can not be null!")
    private String password;


    private CustomerDTO() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static final class CustomerDTOBuilder {
        private long id;
        private String email;
        private String name;
        private String address;
        private Date creation;
        private String password;

        private CustomerDTOBuilder() {
        }

        public static CustomerDTOBuilder aCustomerDTO() {
            return new CustomerDTOBuilder();
        }

        public CustomerDTOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public CustomerDTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerDTOBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerDTOBuilder withCreation(Date creation) {
            this.creation = creation;
            return this;
        }

        public CustomerDTOBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerDTO build() {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(id);
            customerDTO.setEmail(email);
            customerDTO.setName(name);
            customerDTO.setAddress(address);
            customerDTO.setCreation(creation);
            customerDTO.setPassword(password);
            return customerDTO;
        }
    }
}
