package com.janlenart.springshop.api.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemDTO {

    private String name;
    private String description;
    private String barcode;
    private float price;
    private int quantity;
    private String priceCurrency;

    @JsonBackReference
    @JsonProperty("order")
    private OrderInfoDTO orderInfoDTO;
}
