package com.janlenart.springshop.api.dto;

import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.Data;

@Data
public class ItemDTO {

    private int id;
    private OrderInfo orderInfo;
    private String name;
    private String description;
    private String barcode;
    private float price;
    private int quantity;
    private String priceCurrency;
}
