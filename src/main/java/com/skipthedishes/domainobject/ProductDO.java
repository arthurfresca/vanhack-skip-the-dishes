package com.skipthedishes.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "products"
)
public class ProductDO {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @OneToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreDO store;

    @Column(nullable = false)
    @NotNull(message = "Name can not be null!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Description can not be null!")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Price can not be null!")
    private Double price;

    @Column
    private Boolean isActive;

    private ProductDO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public StoreDO getStore() {
        return store;
    }

    public void setStore(StoreDO storeId) {
        this.store = store;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class ProductDOBuilder {
        private long id;
        private ZonedDateTime dateCreated = ZonedDateTime.now();
        private StoreDO store;
        private String description;
        private Double price;
        private Boolean isActive;
        private String name;

        public ProductDOBuilder() {
        }

        public static ProductDOBuilder aProductDO() {
            return new ProductDOBuilder();
        }

        public ProductDOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public ProductDOBuilder withDateCreated(ZonedDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public ProductDOBuilder withStore(StoreDO storeId) {
            this.store = store;
            return this;
        }

        public ProductDOBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductDOBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public ProductDOBuilder withIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public ProductDOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductDO build() {
            ProductDO productDO = new ProductDO();
            productDO.setId(id);
            productDO.setDateCreated(dateCreated);
            productDO.setStore(store);
            productDO.setDescription(description);
            productDO.setPrice(price);
            productDO.setActive(isActive);
            productDO.setName(name);
            return productDO;
        }
    }
}
