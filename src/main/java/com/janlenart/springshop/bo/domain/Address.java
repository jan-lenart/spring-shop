package com.janlenart.springshop.bo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private int houseNr;
    private int apartmentNr;


    public Address(String city, String street, int houseNr, int apartmentNr) {
        this.city = city;
        this.street = street;
        this.houseNr = houseNr;
        this.apartmentNr = apartmentNr;
    }
}
