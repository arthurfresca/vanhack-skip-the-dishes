package com.skipthedishes.controller.mapper;

import com.skipthedishes.dataaccessobject.CustomerRepository;
import com.skipthedishes.datatransferobject.v1.OrderDTO;
import com.skipthedishes.datatransferobject.v1.OrderItemDTO;
import com.skipthedishes.domainobject.CustomerDO;
import com.skipthedishes.domainobject.OrderDO;
import com.skipthedishes.domainobject.OrderItemDO;
import com.skipthedishes.domainobject.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    @Autowired
    CustomerRepository customerRepository;

    public static OrderDO makeOrderDO(OrderDTO orderDTO) {
        return new OrderDO.OrderDOBuilder()
                .withDate(orderDTO.getDate())
                .withDeliveryAddress(orderDTO.getDeliveryAddress())
                .withId(orderDTO.getId())
                .withStatus(orderDTO.getStatus())
                .withTotal(orderDTO.getTotal())
                .withCustomer(CustomerDO.CustomerDOBuilder.aCustomerDO().withId(orderDTO.getCustomerId()).build())
                .withOrderItems(makeOrderItemDOList(orderDTO.getOrderItems()))
                .withIsActive(true)
                .build();
    }


    public static OrderDTO makeOrderDTO(OrderDO orderDO) {
        return OrderDTO.OrderDTOBuilder.anOrderDTO()
                .withId(orderDO.getId())
               // .withCustomerId(orderDO.getCustomer().getId())
                .withDate(orderDO.getDate())
                .withDeliveryAddress(orderDO.getDeliveryAddress())
                .withOrderItems(makeOrderItemDTOList(orderDO.getOrderItems()))
                .withStatus(orderDO.getStatus())
              //  .withStoreId(orderDO.getStore().getId())
                .withTotal(orderDO.getTotal())
                .build();
    }

    public static OrderItemDTO makeOrderItemDTO(OrderItemDO orderItemDO){
        return OrderItemDTO.OrderItemDTOBuilder.anOrderItemDTO()
                .withId(orderItemDO.getId())
                .withOrderId(orderItemDO.getOrder().getId())
                .withProductDTO(ProductMapper.makeProductDTO(orderItemDO.getProduct()))
                .build();
    }

    public static OrderItemDO makeOrderItemDO(OrderItemDTO orderItemDTO){
        return OrderItemDO.OrderItemDOBuilder.anOrderItemDO()
                .withId(orderItemDTO.getId())
                .withOrder(OrderDO.OrderDOBuilder.anOrderDO().withId(orderItemDTO.getOrderId()).build())
                .withProduct(ProductDO.ProductDOBuilder.aProductDO().withId(orderItemDTO.getProductId()).build())
                .withProductId(orderItemDTO.getProductId())
                .build();
    }

    public static List<OrderItemDTO> makeOrderItemDTOList(Collection<OrderItemDO> ordersItems){
       return ordersItems.stream()
                .map(OrderMapper::makeOrderItemDTO)
                .collect(Collectors.toList());
    }

    public static List<OrderItemDO> makeOrderItemDOList(Collection<OrderItemDTO> ordersItems){
        return ordersItems.stream()
                .map(OrderMapper::makeOrderItemDO)
                .collect(Collectors.toList());
    }


}
