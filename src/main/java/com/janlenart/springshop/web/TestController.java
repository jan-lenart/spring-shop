package com.janlenart.springshop.web;

import com.janlenart.springshop.api.Item;
import com.janlenart.springshop.api.OrderInfo;
import com.janlenart.springshop.service.ItemService;
import com.janlenart.springshop.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    private final ItemService itemService;
    private final OrderService orderService;

    public TestController(ItemService itemService, OrderService orderService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @GetMapping("/item/{id}")
    public Item showItems(@PathVariable int id) {
        return itemService.showItem(id);
    }

    @GetMapping("/customer")
    public int showCustomerId() {
        return 1;
    }

    @GetMapping("/item/list")
    public List<Item> listItems() {
        return itemService.listItems();
    }

    @GetMapping("/order/{id}")
    public OrderInfo showOrder(@PathVariable int id) {
        return orderService.showOrder(id);
    }

    @PostMapping("/order/new")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderInfo createOrder(@RequestBody int customerId) {
        return orderService.createOrder(customerId);
    }

}
