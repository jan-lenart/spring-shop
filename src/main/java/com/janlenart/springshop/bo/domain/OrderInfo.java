package com.janlenart.springshop.bo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class OrderInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime orderDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item> items;

    private float totalPrice;
    private String totalPriceCurrency;
    private OrderStatus status;


    public void updateTotalPrice() {

        float totalPrice = 0.0f;
        for (Item item : this.items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        this.totalPrice = totalPrice;
    }

    public void pay() {
        setStatus(OrderStatus.PAID);
    }

}
