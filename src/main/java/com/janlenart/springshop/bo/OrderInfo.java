package com.janlenart.springshop.bo;

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

    @OneToOne
    private Customer customer;

    private float totalPrice;
    private String totalPriceCurrency;
    private String status;

}
