package com.skipthedishes.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "customers"
)
public class CustomerDO {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    @NotNull(message = "Email can not be null!")
    private String email;

    @Column
    @NotNull(message = "Name can not be null!")
    private String name;

    @Column
    @NotNull(message = "Address can not be null!")
    private String address;

    @Column
    @NotNull(message = "Password can not be null!")
    private String password;

    @Column
    private Boolean isActive;


    private CustomerDO() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public static final class CustomerDOBuilder {
        private long id;
        private ZonedDateTime dateCreated = ZonedDateTime.now();
        private String email;
        private String name;
        private String address;
        private String password;
        private Boolean isActive;

        private CustomerDOBuilder() {
        }

        public static CustomerDOBuilder aCustomerDO() {
            return new CustomerDOBuilder();
        }

        public CustomerDOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public CustomerDOBuilder withDateCreated(ZonedDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public CustomerDOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerDOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerDOBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerDOBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerDOBuilder withIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public CustomerDO build() {
            CustomerDO customerDO = new CustomerDO();
            customerDO.setId(id);
            customerDO.setEmail(email);
            customerDO.setName(name);
            customerDO.setAddress(address);
            customerDO.setPassword(password);
            customerDO.setActive(isActive);
            return customerDO;
        }
    }
}
