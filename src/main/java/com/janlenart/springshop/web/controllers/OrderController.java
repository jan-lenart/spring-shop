package com.janlenart.springshop.web.controllers;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.domain.OrderInfo;
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
    //todo change to return DTO
    public OrderInfo showOrder(@PathVariable int id) {
        return orderService.showOrder(id);
    }

    @PostMapping("/order/new")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderInfoDTO createOrder(@RequestBody OrderCommand order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/order/validate")
    public OrderInfoDTO validateOrder(@RequestBody int orderId) {
        return orderService.validateOrder(orderId);
    }
}
