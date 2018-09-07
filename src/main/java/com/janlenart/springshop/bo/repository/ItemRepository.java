package com.janlenart.springshop.bo.repository;

import com.janlenart.springshop.bo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
