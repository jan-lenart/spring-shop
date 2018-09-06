package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime orderDateTime;
    private int customerId;
    @OneToOne
    private Customer customer;

    private float totalPrice;
    private String totalPriceCurrency;
    private String status;

}
