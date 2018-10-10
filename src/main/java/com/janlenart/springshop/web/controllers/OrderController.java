package com.janlenart.springshop.web.controllers;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public OrderInfoDTO showOrder(@PathVariable Long id) {
        return orderService.showOrder(id);
    }

    @PostMapping("/order/new")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderInfoDTO createOrder(@RequestBody OrderCommand order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/order/pay")
    public OrderInfoDTO pay(@RequestBody Long orderId) {
        return orderService.pay(orderId);
    }
}
