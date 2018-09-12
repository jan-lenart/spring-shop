package com.janlenart.springshop.bo;

import lombok.Data;

import javax.persistence.*;

@Data
//@EqualsAndHashCode(of = "id")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String pesel;

    @OneToOne
    private Address shippingAddress;
}
