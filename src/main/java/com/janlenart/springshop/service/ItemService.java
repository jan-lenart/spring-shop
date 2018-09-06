package com.janlenart.springshop.service;

import com.janlenart.springshop.api.Item;
import com.janlenart.springshop.api.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item showItem(int id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    public List<Item> listItemsById(List<Integer> itemIdList) {
        List<Item> itemList = new ArrayList<>();
        for (int i : itemIdList) {
            Item item = null;
            if (itemRepository.findById(i).isPresent()) {
                item = itemRepository.findById(i).get();
            }
            itemList.add(item);
        }
        return itemList;
    }
}
