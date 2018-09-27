package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderDTOFactory;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.api.exceptions.ResourceNotFoundException;
import com.janlenart.springshop.bo.domain.OrderFactory;
import com.janlenart.springshop.bo.domain.OrderInfo;
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

    public OrderInfoDTO showOrder(int id) {
        Optional<OrderInfo> orderInfoOptional = orderRepository.findById(id);
        OrderInfo orderInfo;

        orderInfo = orderInfoOptional.orElseThrow(ResourceNotFoundException::new);

        return OrderDTOFactory.createOrderInfoDto(orderInfo);
    }

    public OrderInfoDTO createOrder(OrderCommand newOrder) {

        OrderInfo orderInfo = OrderFactory.createOrderInfo(newOrder);
        OrderInfo persistedOrder;

        persistedOrder = orderRepository.save(orderInfo);

        return OrderDTOFactory.createOrderInfoDto(persistedOrder);
    }


    public OrderInfoDTO validateOrder(int id) {
        OrderInfo order;
        Optional<OrderInfo> orderInfoOptional = orderRepository.findById(id);

        if (orderInfoOptional.isPresent()) {
            order = orderInfoOptional.get();
            order.pay();
            return OrderDTOFactory.createOrderInfoDto(order);
        }

        String errorMsg = "Order with ID: " + id + " not found.";
        log.error(errorMsg);
        throw new ResourceNotFoundException(errorMsg);
    }

}
