package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.bo.Item;
import com.janlenart.springshop.bo.OrderInfo;
import com.janlenart.springshop.bo.repository.AddressRepository;
import com.janlenart.springshop.bo.repository.CustomerRepository;
import com.janlenart.springshop.bo.repository.ItemRepository;
import com.janlenart.springshop.bo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private OrderCommand orderCommand;


    public OrderService(ItemRepository itemRepository, OrderRepository orderRepository, CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.orderCommand = new OrderCommand();
    }


    public OrderInfo showOrder(int id) {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.findById(id).get();
        }
        return null;
    }

    public OrderInfo createOrder(OrderCommand newOrder) {
        this.orderCommand = newOrder;
        saveAddress();
        saveOrder();
        saveItems();
        saveCustomer();
        orderCommand.updateAllIds();
        orderCommand.updateTotalPrice();
        saveAddress();
        saveOrder();
        saveItems();
        saveCustomer();
        return orderCommand.getOrder();
    }

    public OrderInfo validateOrder(int id) {
        OrderInfo order;
        if (orderRepository.findById(id).isPresent()) {
            order = orderRepository.findById(id).get();
            order.setStatus("PAID");
            return order;
        }
        return null;
    }

    private boolean saveAddress() {
        if (this.orderCommand.getShippingAddress() != null) {
            this.addressRepository.save(this.orderCommand.getShippingAddress());
            return true;
        }
        return false;
    }

    private boolean saveOrder() {
        if (this.orderCommand != null) {
            this.orderCommand.getOrder().setOrderDateTime(LocalDateTime.now());
            this.orderCommand.getOrder().setStatus("CREATED");
            this.orderRepository.save(this.orderCommand.getOrder());
            return true;
        }
        return false;
    }

    private boolean saveItems() {
        if (this.orderCommand.getItemList() != null) {
            for (Item item : this.orderCommand.getItemList()) {
                this.itemRepository.save(item);
            }
            return true;
        }
        return false;
    }

    private boolean saveCustomer() {
        if (this.orderCommand.getCustomer() != null) {
            this.customerRepository.save(this.orderCommand.getCustomer());
            return true;
        }
        return false;
    }


}
