package com.janlenart.springshop.api;

import com.janlenart.springshop.bo.Address;
import com.janlenart.springshop.bo.Customer;
import com.janlenart.springshop.bo.Item;
import com.janlenart.springshop.bo.OrderInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


//@Component
@Data
//@EqualsAndHashCode(of = "id")
public class OrderCommand {

    // == fields ==
//    private int id;
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

    // == private methods ==

    private boolean updateOrderIdInItem() {
        if (this.itemList != null) {
            if (this.order != null) {
                for (Item item : this.itemList) {
                    item.setOrder(this.order);
                }
            }
            return true;
        }
        return false;
    }

    private boolean updateCustomerIdInOrder() {
        if (this.order != null) {
            if (this.customer != null) {
                this.order.setCustomer(this.customer);
                return true;
            }
        }
        return false;
    }

    private boolean updateAddressInCustomer() {
        if (this.customer != null) {
            if (this.shippingAddress != null) {
                this.customer.setShippingAddress(this.shippingAddress);
                return true;
            }
        }
        return false;
    }

    // == public methods ==

    public boolean updateAllIds() {
        return (updateAddressInCustomer() && updateCustomerIdInOrder() && updateOrderIdInItem());
    }

    public void updateTotalPrice() {
        float totalPrice = 0.0f;
        for (Item item : this.itemList) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        this.order.setTotalPrice(totalPrice);
    }

}

