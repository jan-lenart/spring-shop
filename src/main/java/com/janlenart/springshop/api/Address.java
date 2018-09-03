package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Address {

    private int id;
    private String city;
    private String street;
    private int houseNr;
    private int ApartmentNr;

}
