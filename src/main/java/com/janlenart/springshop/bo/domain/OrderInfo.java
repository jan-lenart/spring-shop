package com.janlenart.springshop.bo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class OrderInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime orderDateTime;

    @OneToOne
    private Customer customer;

    private float totalPrice;
    private String totalPriceCurrency;
    private String status;

}
