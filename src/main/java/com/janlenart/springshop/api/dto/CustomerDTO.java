package com.janlenart.springshop.api.dto;


import lombok.Data;

@Data
public class CustomerDTO {

    private String name;
    private String surname;
    private String pesel;
    private AddressDTO addressDTO;
}
