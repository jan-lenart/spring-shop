package com.janlenart.springshop.bo.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String barcode;
    private float price;
    private int quantity;
    private String priceCurrency;

    @ManyToOne
    @JoinColumn(name = "ORDER_INFO_ID")
    private OrderInfo orderInfo;

    public Item(String name, String description, String barcode, float price, int quantity, String priceCurrency, OrderInfo orderInfo) {
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.priceCurrency = priceCurrency;
        this.orderInfo = orderInfo;
    }
}
