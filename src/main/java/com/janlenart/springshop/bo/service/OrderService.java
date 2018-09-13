package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.exceptions.ResourceNotFoundException;
import com.janlenart.springshop.bo.domain.Item;
import com.janlenart.springshop.bo.domain.OrderInfo;
import com.janlenart.springshop.bo.repository.AddressRepository;
import com.janlenart.springshop.bo.repository.CustomerRepository;
import com.janlenart.springshop.bo.repository.ItemRepository;
import com.janlenart.springshop.bo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderService {

    // == fields ==
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private OrderCommand orderCommand;


    // == constructors ==
    public OrderService(ItemRepository itemRepository,
                        OrderRepository orderRepository,
                        CustomerRepository customerRepository,
                        AddressRepository addressRepository) {

        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.orderCommand = new OrderCommand();
    }

    // == public methods ==

    public OrderInfo showOrder(int id) {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.findById(id).get();
        }
        return null;
    }

    public OrderInfo createOrder(OrderCommand newOrder) {
        this.orderCommand = newOrder;
        saveOrder();
        saveCustomer();
        saveAddress();
        saveItems();
        updateAllIds(newOrder);
        updateTotalPrice(newOrder);
        saveOrder();
        saveCustomer();
        saveAddress();
        saveItems();
        return orderCommand.getOrder();
    }

    public OrderInfo validateOrder(int id) {
        OrderInfo order;
        if (orderRepository.findById(id).isPresent()) {
            order = orderRepository.findById(id).get();
            order.setStatus("PAID");
            return order;
        }

        log.error("Order with ID: " + id + " not found.");
        throw new ResourceNotFoundException("Order with ID: " + id + " not found.");
    }


    public void updateAllIds(OrderCommand order) {
        updateAddressInCustomer(order);
        updateCustomerIdInOrder(order);
        updateOrderIdInItem(order);
    }

    public void updateTotalPrice(OrderCommand order) {
        float totalPrice = 0.0f;
        for (Item item : order.getItemList()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        order.getOrder().setTotalPrice(totalPrice);
    }

    // == private methods ==

    private void saveAddress() {
        if (this.orderCommand.getShippingAddress() != null) {
            this.addressRepository.save(this.orderCommand.getShippingAddress());
        }
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

    private boolean updateOrderIdInItem(OrderCommand order) {
        if (order.getItemList() != null) {
            if (order.getOrder() != null) {
                for (Item item : order.getItemList()) {
                    item.setOrder(order.getOrder());
                }
            }
            return true;
        }
        return false;
    }

    private boolean updateCustomerIdInOrder(OrderCommand order) {
        if (order.getOrder() != null) {
            if (order.getCustomer() != null) {
                order.getOrder().setCustomer(order.getCustomer());
                return true;
            }
        }
        return false;
    }

    private boolean updateAddressInCustomer(OrderCommand order) {
        if (order.getCustomer() != null) {
            if (order.getShippingAddress() != null) {
                order.getCustomer().setShippingAddress(order.getShippingAddress());
                return true;
            }
        }
        return false;
    }


}
