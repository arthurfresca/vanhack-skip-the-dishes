package com.skipthedishes.datatransferobject.v1;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {

    private long id;
    private long orderId;
    private long productId;
    private ProductDTO productDTO;

    private OrderItemDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }


    public static final class OrderItemDTOBuilder {
        private long id;
        private long orderId;
        private long productId;
        private ProductDTO productDTO;

        private OrderItemDTOBuilder() {
        }

        public static OrderItemDTOBuilder anOrderItemDTO() {
            return new OrderItemDTOBuilder();
        }

        public OrderItemDTOBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public OrderItemDTOBuilder withOrderId(long orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderItemDTOBuilder withProductId(long productId) {
            this.productId = productId;
            return this;
        }

        public OrderItemDTOBuilder withProductDTO(ProductDTO productDTO) {
            this.productDTO = productDTO;
            return this;
        }

        public OrderItemDTO build() {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setId(id);
            orderItemDTO.setOrderId(orderId);
            orderItemDTO.setProductId(productId);
            orderItemDTO.setProductDTO(productDTO);
            return orderItemDTO;
        }
    }
}
