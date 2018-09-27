package com.janlenart.springshop.bo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Data
//@EqualsAndHashCode(of = {"pesel", "name", "surname"})
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String pesel;

    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;

}
