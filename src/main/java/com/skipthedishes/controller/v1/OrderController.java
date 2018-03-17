package com.skipthedishes.controller.v1;

import com.skipthedishes.controller.mapper.OrderMapper;
import com.skipthedishes.datatransferobject.v1.OrderDTO;
import com.skipthedishes.domainobject.OrderDO;
import com.skipthedishes.domainvalue.Status;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.EntityNotFoundException;
import com.skipthedishes.exception.InvalidCredentialException;
import com.skipthedishes.exception.UnnexpectedException;
import com.skipthedishes.service.AuthenticateService;
import com.skipthedishes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * All operations with a order will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("api/v1/Order")
public class OrderController {

    private final OrderService orderService;

    private final AuthenticateService authenticateService;

    @Autowired
    public OrderController(final OrderService orderService, final AuthenticateService authenticateService) {
        this.orderService = orderService;
        this.authenticateService = authenticateService;
    }

    @GetMapping("/customer")
    public String getCustomerOrder(@RequestHeader(value = "Authorization") String token) {
        return "";
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderId(@RequestHeader(value = "Authorization") String token,
                               @Valid @PathVariable Long orderId) throws EntityNotFoundException, InvalidCredentialException {
        authenticateService.authenticateToken(token);
        return OrderMapper.makeOrderDTO(orderService.find(orderId));
    }

    @GetMapping("getOrderStatus/{orderId}")
    public Status getOrderStatus(@RequestHeader(value = "Authorization") String token,
                                 @Valid @PathVariable Long orderId) throws EntityNotFoundException, InvalidCredentialException {
        authenticateService.authenticateToken(token);
        return orderService.getOrderStatus(orderId);
    }

    @PostMapping("/")
    public OrderDTO createUpdateOrder(@RequestHeader(value = "Authorization") String token,
                                      @Valid @RequestBody OrderDTO orderDTO) throws ConstraintsViolationException, InvalidCredentialException {
        authenticateService.authenticateToken(token);
        OrderDO orderDO = OrderMapper.makeOrderDO(orderDTO);
        return OrderMapper.makeOrderDTO(orderService.createOrUpdate(orderDO));
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public HttpStatus createUpdateOrder(@RequestHeader(value = "Authorization") String token,
                                        @Valid @PathVariable Long orderId) throws EntityNotFoundException, UnnexpectedException, InvalidCredentialException {
        authenticateService.authenticateToken(token);
        if(orderService.cancel(orderId)){
            return HttpStatus.ACCEPTED;
        } else {
            throw new UnnexpectedException("Something unnexpected happened");
        }
    }
}
