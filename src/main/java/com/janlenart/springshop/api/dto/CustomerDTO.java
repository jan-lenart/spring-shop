package com.janlenart.springshop.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDTO {

    private int id;
    private String name;
    private String surname;
    private String pesel;
    private AddressDTO addressDTO;
}
