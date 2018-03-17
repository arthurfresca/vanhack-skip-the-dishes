package com.skipthedishes.service;

import com.skipthedishes.dataaccessobject.OrderRepository;
import com.skipthedishes.domainobject.OrderDO;
import com.skipthedishes.domainobject.ProductDO;
import com.skipthedishes.domainvalue.Status;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.EmptyListException;
import com.skipthedishes.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some order specific things.
 * <p/>
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderDO find(Long orderId) throws EntityNotFoundException {
        return findOrderChecked(orderId);
    }

    @Override
    public Status getOrderStatus(Long orderId) throws EntityNotFoundException {
        return find(orderId).getStatus();
    }

    @Override
    public OrderDO createOrUpdate(OrderDO orderDO) throws ConstraintsViolationException {
        try {
            orderDO.setActive(true);
            orderDO.setCustomer(null);
            orderRepository.save(orderDO);
        }
        catch (DataIntegrityViolationException e) {
            LOG.warn("Some constraints are thrown due to order creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return orderDO;
    }

    @Override
    public boolean cancel(Long orderId) throws EntityNotFoundException {
        OrderDO order = find(orderId);
        order.setActive(false);
        orderRepository.save(order);
        return true;
    }

    @Override
    public List<ProductDO> findAll() {
        return null;
    }

    private OrderDO findOrderChecked(Long orderId) throws EntityNotFoundException {
        OrderDO orderDO = orderRepository.findFirstByIdAndIsActiveTrue(orderId);
        checkExceptions(orderDO);
        return orderDO;
    }

    private void checkExceptions(OrderDO orderDO) throws EntityNotFoundException {
        if (orderDO == null) {
            String ex = "Could not find entity";
            throw new EntityNotFoundException(ex);
        }
    }

    private void checkExceptions(List<OrderDO> ordersDO) throws EmptyListException {
        if (ordersDO.size() == 0) {
            String ex = "Order list is empty";
            throw new EmptyListException(ex);
        }
    }

}
