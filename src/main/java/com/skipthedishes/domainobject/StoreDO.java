package com.skipthedishes.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "stores"
)
public class StoreDO {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    @NotNull(message = "Name can not be null!")
    private String name;

    @Column
    @NotNull(message = "Address can not be null!")
    private String address;

    @Column
    private long cousineId;

    @Column
    private Boolean isActive;

    public StoreDO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getCousineId() {
        return cousineId;
    }

    public void setCousineId(long cousineId) {
        this.cousineId = cousineId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public static final class StoreDOBuilder {
        private long id;
        private ZonedDateTime dateCreated = ZonedDateTime.now();
        private String name;
        private String address;
        private long cousineId;
        private Boolean isActive;

        private StoreDOBuilder() {
        }

        public static StoreDOBuilder aStoreDO() {
            return new StoreDOBuilder();
        }

        public StoreDOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public StoreDOBuilder withDateCreated(ZonedDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public StoreDOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StoreDOBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public StoreDOBuilder withCousineId(long cousineId) {
            this.cousineId = cousineId;
            return this;
        }

        public StoreDOBuilder withIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public StoreDO build() {
            StoreDO storeDO = new StoreDO();
            storeDO.setId(id);
            storeDO.setName(name);
            storeDO.setAddress(address);
            storeDO.setCousineId(cousineId);
            storeDO.setActive(isActive);
            return storeDO;
        }
    }
}
