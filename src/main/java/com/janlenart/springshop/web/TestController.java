package com.janlenart.springshop.web;

import com.janlenart.springshop.api.Item;
import com.janlenart.springshop.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ItemService itemService;

    public TestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{id}")
    public Item showItems(@PathVariable int id) {
        return itemService.listItems(id);
    }

}
