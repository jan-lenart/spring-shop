package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Customer {

    private int id;
    private String name;
    private String surname;
    private String pesel;
    private int shippingAddressId;

}
