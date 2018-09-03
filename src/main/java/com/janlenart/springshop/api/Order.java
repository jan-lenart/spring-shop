package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
public class Order {

    private int id;
    private LocalDateTime orderDateTime;
    private int customerId;
    private float totalPrice;
    private String totalPriceCurrency;
    private String status;

}
