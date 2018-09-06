package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private OrderInfo order;
    private int orderId;

    private String name;
    private String description;
    private String barcode;
    private float price;
    private String price_currency;

}
