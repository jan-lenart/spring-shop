package com.janlenart.springshop.bo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Item> items;

    private OrderStatus status;

    private float totalPrice = 0.0f;

    private LocalDateTime orderDateTime;

    private String totalPriceCurrency;

    OrderInfo(Customer customer,  LocalDateTime orderDateTime) {
        this.customer = customer;
        this.orderDateTime = orderDateTime;
        this.status = OrderStatus.CREATED;
        this.items = new HashSet<>();
    }

    public void pay() {
        this.status = OrderStatus.PAID;
    }

    void addItems(Collection<Item> items) {
        this.items.addAll(items);
        recalculateTotalPrice();
    }

    void recalculateTotalPrice() {

        float totalPrice = 0.0f;
        for (Item item : this.items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        this.totalPrice = totalPrice;
    }




}
