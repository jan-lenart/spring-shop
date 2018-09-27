package com.janlenart.springshop.bo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor//(access = AccessLevel.PACKAGE)
@AllArgsConstructor//(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item> items;

    @Builder.Default private OrderStatus status = OrderStatus.CREATED;

    @Builder.Default private float totalPrice = 0.0f;

    private LocalDateTime orderDateTime;

    private String totalPriceCurrency;


    void updateTotalPrice() {

        float totalPrice = 0.0f;
        for (Item item : this.items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        this.totalPrice = totalPrice;
    }

    public void pay() {
        this.status = OrderStatus.PAID;
    }

    void setItems(List<Item> items) {
        this.items = items;
    }

}
