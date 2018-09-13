package com.janlenart.springshop.bo.repository;

import com.janlenart.springshop.bo.domain.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderInfo, Integer> {
}
