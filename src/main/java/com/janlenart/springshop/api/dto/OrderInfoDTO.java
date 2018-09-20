package com.janlenart.springshop.api.dto;

import com.janlenart.springshop.bo.domain.Customer;
import com.janlenart.springshop.bo.domain.Item;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderInfoDTO {

    private Integer id;
    private LocalDateTime orderDateTime;
    private Customer customer;
    private List<Item> itemList;
    private float totalPrice;
    private String totalPriceCurrency;
    private String status;
}
