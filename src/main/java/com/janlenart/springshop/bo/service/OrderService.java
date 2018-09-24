package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.api.exceptions.ResourceNotFoundException;
import com.janlenart.springshop.bo.assemblers.OrderInfoAssembler;
import com.janlenart.springshop.bo.domain.OrderInfo;
import com.janlenart.springshop.bo.domain.OrderStatus;
import com.janlenart.springshop.bo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderInfo showOrder(int id) {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.findById(id).get();
        }
        return null;
    }

    public OrderInfoDTO createOrder(OrderCommand newOrder) {

        OrderInfo orderInfo = OrderInfoAssembler.unpackDto(newOrder.getOrderInfoDTO());

        orderInfo.setStatus(OrderStatus.CREATED);
        orderInfo.updateTotalPrice();

        orderRepository.save(orderInfo);

        int orderId = orderInfo.getId();

        //todo add isPresent()
        return OrderInfoAssembler.writeDto(orderRepository.findById(orderId).get());
    }


    public OrderInfoDTO validateOrder(int id) {
        OrderInfo order;
        Optional<OrderInfo> orderInfoOptional = orderRepository.findById(id);

        if (orderInfoOptional.isPresent()) {
            order = orderInfoOptional.get();
            order.pay();
            return OrderInfoAssembler.writeDto(order);
        }

        log.error("Order with ID: " + id + " not found.");
        throw new ResourceNotFoundException("Order with ID: " + id + " not found.");
    }

}
