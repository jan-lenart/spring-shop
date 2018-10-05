package com.janlenart.springshop.bo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo orderInfo = (OrderInfo) o;

        if (id != orderInfo.id) return false;
        if (Float.compare(orderInfo.totalPrice, totalPrice) != 0) return false;
        if (!customer.equals(orderInfo.customer)) return false;
        if (!items.equals(orderInfo.items)) return false;
        if (status != orderInfo.status) return false;
        if (!orderDateTime.equals(orderInfo.orderDateTime)) return false;
        return totalPriceCurrency.equals(orderInfo.totalPriceCurrency);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customer.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + (totalPrice != +0.01f ? Float.floatToIntBits(totalPrice) : 0);
        result = 31 * result + orderDateTime.hashCode();
        result = 31 * result + totalPriceCurrency.hashCode();
        return result;
    }
}
