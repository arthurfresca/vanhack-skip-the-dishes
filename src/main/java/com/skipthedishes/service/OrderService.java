package com.skipthedishes.service;

import com.skipthedishes.domainobject.OrderDO;
import com.skipthedishes.domainobject.ProductDO;
import com.skipthedishes.domainvalue.Status;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.EntityNotFoundException;

import java.util.List;

public interface OrderService {

    Status getOrderStatus(Long orderId) throws EntityNotFoundException;

    OrderDO find(Long orderId) throws EntityNotFoundException;

    OrderDO createOrUpdate(OrderDO orderDO) throws ConstraintsViolationException;

    boolean cancel(Long orderId) throws EntityNotFoundException;

    List<ProductDO> findAll();

}
