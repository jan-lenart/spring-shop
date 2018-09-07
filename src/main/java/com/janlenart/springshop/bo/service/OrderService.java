package com.janlenart.springshop.bo.service;

import com.janlenart.springshop.bo.Item;
import com.janlenart.springshop.bo.OrderInfo;
import com.janlenart.springshop.bo.repository.ItemRepository;
import com.janlenart.springshop.bo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;


    public OrderService(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public OrderInfo createOrder(int customerId, List<Integer> itemsById) {

        OrderInfo newOrder = new OrderInfo();
        List<Item> itemList = new ArrayList<>();
        float totalPrice =0f;

        for (int i : itemsById) {
            if (itemRepository.findById(i).isPresent()) {
                itemList.add(itemRepository.findById(i).get());
            }
        }

        newOrder.setOrderDateTime(LocalDateTime.now());
        newOrder.setCustomerId(customerId);
        newOrder.setTotalPriceCurrency("PLN");
        newOrder.setStatus("CREATED");
        orderRepository.save(newOrder);

        Iterator<Item> itemIterator = itemList.iterator();
        while (itemIterator.hasNext()) {
            Item currentItem = itemIterator.next();
            totalPrice += currentItem.getPrice();
            currentItem.setOrderId(newOrder.getId());
        }

        newOrder.setTotalPrice(totalPrice);
        orderRepository.save(newOrder);

        return newOrder;
    }

    public OrderInfo createOrder(int customerId) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        return createOrder(customerId,list);
    }

    public OrderInfo showOrder(int id) {
        return orderRepository.findById(id).get();
    }


    public OrderInfo validateOrder(int id) {
        OrderInfo order;
        if (orderRepository.findById(id).isPresent()) {
            order = orderRepository.findById(id).get();
            order.setStatus("PAID");
        }
        return null;
    }
}
