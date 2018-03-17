package com.skipthedishes.domainobject;

import com.skipthedishes.domainvalue.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "orders"
)
public class OrderDO {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    private Date date;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerDO customer;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "order")
    private List<OrderItemDO> orderItems;

    @Column
    @NotNull(message = "Address can not be null!")
    private String deliveryAddress;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreDO store;

    @Column
    private Double total;

    @Column
    private Status status;

    @Column
    private Date lastUpdate;

    @Column
    private Boolean isActive;


    private OrderDO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CustomerDO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDO customer) {
        this.customer = customer;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public StoreDO getStore() {
        return store;
    }

    public void setStore(StoreDO store) {
        this.store = store;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<OrderItemDO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDO> orderItems) {
        this.orderItems = orderItems;
    }


    public static final class OrderDOBuilder {
        private long id;
        private Date date;
        private CustomerDO customer;
        private List<OrderItemDO> orderItems;
        private String deliveryAddress;
        private StoreDO store;
        private Double total;
        private Status status;
        private Date lastUpdate;
        private Boolean isActive;

        public OrderDOBuilder() {
        }

        public static OrderDOBuilder anOrderDO() {
            return new OrderDOBuilder();
        }

        public OrderDOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public OrderDOBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public OrderDOBuilder withCustomer(CustomerDO customer) {
            this.customer = customer;
            return this;
        }

        public OrderDOBuilder withOrderItems(List<OrderItemDO> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public OrderDOBuilder withDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderDOBuilder withStore(StoreDO store) {
            this.store = store;
            return this;
        }

        public OrderDOBuilder withTotal(Double total) {
            this.total = total;
            return this;
        }

        public OrderDOBuilder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public OrderDOBuilder withLastUpdate(Date lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public OrderDOBuilder withIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public OrderDO build() {
            OrderDO orderDO = new OrderDO();
            orderDO.setId(id);
            orderDO.setDate(date);
            orderDO.setCustomer(customer);
            orderDO.setOrderItems(orderItems);
            orderDO.setDeliveryAddress(deliveryAddress);
            orderDO.setStore(store);
            orderDO.setTotal(total);
            orderDO.setStatus(status);
            orderDO.setLastUpdate(lastUpdate);
            orderDO.setActive(isActive);
            return orderDO;
        }
    }
}
