package com.skipthedishes.datatransferobject.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreDTO {

    private long id;

    @NotNull(message = "Name can not be null!")
    private String name;

    @NotNull(message = "Address can not be null!")
    private String address;

    private long cousineId;

    public StoreDTO() {
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


    public static final class StoreDTOBuilder {
        private long id;
        private String name;
        private String address;
        private long cousineId;

        private StoreDTOBuilder() {
        }

        public static StoreDTOBuilder aStoreDTO() {
            return new StoreDTOBuilder();
        }

        public StoreDTOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public StoreDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StoreDTOBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public StoreDTOBuilder withCousineId(long cousineId) {
            this.cousineId = cousineId;
            return this;
        }

        public StoreDTO build() {
            StoreDTO storeDTO = new StoreDTO();
            storeDTO.setId(id);
            storeDTO.setName(name);
            storeDTO.setAddress(address);
            storeDTO.setCousineId(cousineId);
            return storeDTO;
        }
    }
}
