package com.skipthedishes.datatransferobject.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.skipthedishes.domainvalue.Status;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private long id;
    private Date date;
    private long customerId;
    private String deliveryAddress;
    private long storeId;
    private List<OrderItemDTO> orderItems;
    private Double total;
    private Status status;
    private Date lastUpdate;


    private OrderDTO() {
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
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


    public static final class OrderDTOBuilder {
        private long id;
        private Date date;
        private long customerId;
        private String deliveryAddress;
        private long storeId;
        private List<OrderItemDTO> orderItems;
        private Double total;
        private Status status;
        private Date lastUpdate;

        private OrderDTOBuilder() {
        }

        public static OrderDTOBuilder anOrderDTO() {
            return new OrderDTOBuilder();
        }

        public OrderDTOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public OrderDTOBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public OrderDTOBuilder withCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderDTOBuilder withDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderDTOBuilder withStoreId(long storeId) {
            this.storeId = storeId;
            return this;
        }

        public OrderDTOBuilder withOrderItems(List<OrderItemDTO> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public OrderDTOBuilder withTotal(Double total) {
            this.total = total;
            return this;
        }

        public OrderDTOBuilder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public OrderDTOBuilder withLastUpdate(Date lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public OrderDTO build() {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(id);
            orderDTO.setDate(date);
            orderDTO.setCustomerId(customerId);
            orderDTO.setDeliveryAddress(deliveryAddress);
            orderDTO.setStoreId(storeId);
            orderDTO.setOrderItems(orderItems);
            orderDTO.setTotal(total);
            orderDTO.setStatus(status);
            orderDTO.setLastUpdate(lastUpdate);
            return orderDTO;
        }
    }
}
