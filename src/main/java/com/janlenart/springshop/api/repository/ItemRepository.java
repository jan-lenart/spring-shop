package com.janlenart.springshop.api.repository;

import com.janlenart.springshop.api.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
