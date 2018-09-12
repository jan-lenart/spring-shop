package com.janlenart.springshop.web;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.ResourceNotFoundException;
import com.janlenart.springshop.bo.OrderInfo;
import com.janlenart.springshop.bo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final OrderService orderService;

    public TestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public OrderInfo showOrder(@PathVariable int id) {
        return orderService.showOrder(id);
    }

    @PostMapping("/order/new")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderInfo createOrder(@RequestBody OrderCommand order) {
        //todo - add validation
        return orderService.createOrder(order);
    }

    @PostMapping("/order/validate")
    public OrderInfo validateOrder(@RequestBody int orderId) {
        if (orderService.validateOrder(orderId) == null) {
            //todo - return error
            throw new ResourceNotFoundException();
        }
        return orderService.validateOrder(orderId);
    }
}
