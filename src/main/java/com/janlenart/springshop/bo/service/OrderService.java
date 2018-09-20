package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.api.exceptions.ResourceNotFoundException;
import com.janlenart.springshop.bo.assemblers.AddressAssembler;
import com.janlenart.springshop.bo.assemblers.CustomerAssembler;
import com.janlenart.springshop.bo.assemblers.ItemAssembler;
import com.janlenart.springshop.bo.assemblers.OrderInfoAssembler;
import com.janlenart.springshop.bo.domain.Address;
import com.janlenart.springshop.bo.domain.Customer;
import com.janlenart.springshop.bo.domain.Item;
import com.janlenart.springshop.bo.domain.OrderInfo;
import com.janlenart.springshop.bo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Address address = AddressAssembler.unpackDto(newOrder.getAddressDTO());
        Customer customer = CustomerAssembler.unpackDto(newOrder.getCustomerDTO());
        List<Item> items = ItemAssembler.unpackListDto(newOrder.getItemDTOList(),orderInfo);


        orderInfo.setStatus("CREATED");
        orderInfo.setRelations(items, customer, address);
        orderInfo.updateTotalPrice();

        orderRepository.save(orderInfo);

        int orderId = orderInfo.getId();

        //todo add isPresent()
        return OrderInfoAssembler.writeDto(orderRepository.findById(orderId).get());
    }


    public OrderInfoDTO validateOrder(int id) {
        OrderInfo order;

        if (orderRepository.findById(id).isPresent()) {
            order = orderRepository.findById(id).get();
            order.setStatus("PAID");
            return OrderInfoAssembler.writeDto(order);
        }

        log.error("Order with ID: " + id + " not found.");
        throw new ResourceNotFoundException("Order with ID: " + id + " not found.");
    }

}
