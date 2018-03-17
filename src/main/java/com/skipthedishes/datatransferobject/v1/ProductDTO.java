package com.skipthedishes.datatransferobject.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private long id;
    private long storeId;
    private String description;
    private Double price;

    public ProductDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public static final class ProductDTOBuilder {
        private long id;
        private long storeId;
        private String description;
        private Double price;

        public ProductDTOBuilder() {
        }

        public static ProductDTOBuilder aProductDTO() {
            return new ProductDTOBuilder();
        }

        public ProductDTOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public ProductDTOBuilder withStoreId(long storeId) {
            this.storeId = storeId;
            return this;
        }

        public ProductDTOBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductDTOBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public ProductDTO build() {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(id);
            productDTO.setStoreId(storeId);
            productDTO.setDescription(description);
            productDTO.setPrice(price);
            return productDTO;
        }
    }
}
