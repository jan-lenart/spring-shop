package com.janlenart.springshop.api;

import com.janlenart.springshop.bo.domain.Address;
import com.janlenart.springshop.bo.domain.Customer;
import com.janlenart.springshop.bo.domain.Item;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class OrderCommand {

    // == fields ==
    private OrderInfo order;
    private Customer customer;
    private Address shippingAddress;
    private List<Item> itemList;


    // == constructors ==
    public OrderCommand() {
        this.itemList = new ArrayList<>();
        this.order = new OrderInfo();
        this.customer = new Customer();
        this.shippingAddress = new Address();
    }

}

