package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderDTOFactory;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.api.exceptions.ResourceNotFoundException;
import com.janlenart.springshop.bo.domain.OrderFactory;
import com.janlenart.springshop.bo.domain.OrderInfo;
import com.janlenart.springshop.bo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderInfoDTO showOrder(Long id) {
        Optional<OrderInfo> orderInfoOptional = orderRepository.findById(id);
        OrderInfo orderInfo = orderInfoOptional.orElseThrow(ResourceNotFoundException::new);

        return OrderDTOFactory.createOrderInfoDto(orderInfo);
    }

    public OrderInfoDTO createOrder(OrderCommand newOrder) {
        OrderInfo orderInfo = OrderFactory.createOrderInfo(newOrder);
        OrderInfo persistedOrder = orderRepository.save(orderInfo);

        return OrderDTOFactory.createOrderInfoDto(persistedOrder);
    }

    public OrderInfoDTO pay(Long id) {

        Optional<OrderInfo> orderInfoOptional = orderRepository.findById(id);

        OrderInfo order = orderInfoOptional.orElseThrow(() -> {
            String errorMsg = "Order with ID: " + id + " not found.";
            log.error(errorMsg);
            return new ResourceNotFoundException(errorMsg);
        });

        order.pay();
        return OrderDTOFactory.createOrderInfoDto(order);
    }

}
