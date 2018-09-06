package com.janlenart.springshop.api.repository;

import com.janlenart.springshop.api.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderInfo, Integer> {
}
