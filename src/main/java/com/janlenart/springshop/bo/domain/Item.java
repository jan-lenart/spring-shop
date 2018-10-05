package com.janlenart.springshop.bo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Float.compare(item.price, price) != 0) return false;
        if (quantity != item.quantity) return false;
        if (!name.equals(item.name)) return false;
        if (!description.equals(item.description)) return false;
        if (!barcode.equals(item.barcode)) return false;
        if (!priceCurrency.equals(item.priceCurrency)) return false;
        return orderInfo.equals(item.orderInfo);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + barcode.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + quantity;
        result = 31 * result + priceCurrency.hashCode();
        result = 31 * result + orderInfo.hashCode();
        return result;
    }
}
