package com.skipthedishes.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "order_items"
)
public class OrderItemDO {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderDO order;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductDO product;

    @Column
    private Boolean isActive;

    private OrderItemDO() {
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

    public OrderDO getOrder() {
        return order;
    }

    public void setOrder(OrderDO order) {
        this.order = order;
    }

    public ProductDO getProduct() {
        return product;
    }

    public void setProduct(ProductDO product) {
        this.product = product;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public static final class OrderItemDOBuilder {
        private long id;
        private OrderDO order;
        private long productId;
        private ProductDO product;
        private Boolean isActive;

        private OrderItemDOBuilder() {
        }

        public static OrderItemDOBuilder anOrderItemDO() {
            return new OrderItemDOBuilder();
        }

        public OrderItemDOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public OrderItemDOBuilder withOrder(OrderDO order) {
            this.order = order;
            return this;
        }

        public OrderItemDOBuilder withProductId(long productId) {
            this.productId = productId;
            return this;
        }

        public OrderItemDOBuilder withProduct(ProductDO product) {
            this.product = product;
            return this;
        }

        public OrderItemDOBuilder withIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public OrderItemDO build() {
            OrderItemDO orderItemDO = new OrderItemDO();
            orderItemDO.setId(id);
            orderItemDO.setOrder(order);
            orderItemDO.setProduct(product);
            orderItemDO.setActive(isActive);
            return orderItemDO;
        }
    }
}
