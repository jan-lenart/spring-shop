package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Item {

    private int id;
    private int orderId;
    private String name;
    private String description;
    private String barcode;
    private float price;
    private String price_currency;

}
