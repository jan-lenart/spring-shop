package com.janlenart.springshop.api.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String city;
    private String street;
    private int houseNr;
    private int apartmentNr;
}
