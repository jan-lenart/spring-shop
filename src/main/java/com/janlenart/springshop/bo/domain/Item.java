package com.janlenart.springshop.bo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor//(access = AccessLevel.PACKAGE)
@AllArgsConstructor//(access = AccessLevel.PRIVATE)
//@Builder
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

    @JsonBackReference
    @ManyToOne
    private OrderInfo orderInfo;
}
