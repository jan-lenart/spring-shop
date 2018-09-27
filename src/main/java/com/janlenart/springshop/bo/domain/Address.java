package com.janlenart.springshop.bo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Setter
@Getter
@NoArgsConstructor//(access = AccessLevel.PACKAGE)
@AllArgsConstructor//(access = AccessLevel.PRIVATE)
//@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private String street;
    private int houseNr;
    private int apartmentNr;

}
