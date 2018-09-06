package com.janlenart.springshop.bootstrap;

import com.janlenart.springshop.api.Item;
import com.janlenart.springshop.api.OrderInfo;
import com.janlenart.springshop.api.repository.ItemRepository;
import com.janlenart.springshop.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public BootstrapData(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        populateItems();
        exampleOrder();
    }

    private void populateItems() {
        Item i1 = new Item();
        i1.setName("Apple");
        i1.setDescription("This is an " + i1.getName());
        i1.setBarcode("111");
        i1.setPrice(1.11f);
        i1.setPrice_currency("PLN");
        i1.setOrderId(0);
        itemRepository.save(i1);
        //==============================================

        Item i2 = new Item();
        i2.setName("Banana");
        i2.setDescription("This is a " + i2.getName());
        i2.setBarcode("222");
        i2.setPrice(2.22f);
        i2.setPrice_currency("PLN");
        i2.setOrderId(0);
        itemRepository.save(i2);
        //==============================================

        Item i3 = new Item();
        i3.setName("Cranberry");
        i3.setDescription("This is a " + i3.getName());
        i3.setBarcode("333");
        i3.setPrice(3.33f);
        i3.setPrice_currency("PLN");
        i3.setOrderId(0);
        itemRepository.save(i3);
        //==============================================
    }

    private void exampleOrder() {
        OrderInfo o = new OrderInfo();
        o.setStatus("CREATED");
        o.setCustomerId(1);
        o.setOrderDateTime(LocalDateTime.now());
        o.setTotalPrice(25.5f);
        o.setTotalPriceCurrency("PLN");
        orderRepository.save(o);
    }
}
