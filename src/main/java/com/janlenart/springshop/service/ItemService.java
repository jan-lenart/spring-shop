package com.janlenart.springshop.service;

import com.janlenart.springshop.api.Item;
import com.janlenart.springshop.api.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item listItems(int id) {
        Item item = itemRepository.findById(id).get();
        return item;
    }
}
