package com.janlenart.springshop.bo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(of = {"pesel", "name", "surname"})
@Entity
public class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String pesel;

    @OneToOne
    private Address shippingAddress;
}
