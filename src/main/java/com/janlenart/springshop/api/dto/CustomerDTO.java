package com.janlenart.springshop.api.dto;


import com.janlenart.springshop.bo.domain.Address;
import lombok.Data;

@Data
public class CustomerDTO {

    private int id;
    private String name;
    private String surname;
    private String pesel;
    private Address address;
}
