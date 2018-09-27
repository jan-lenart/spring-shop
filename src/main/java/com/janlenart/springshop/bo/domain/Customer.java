package com.janlenart.springshop.bo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor//(access = AccessLevel.PACKAGE)
@AllArgsConstructor//(access = AccessLevel.PRIVATE)
//@Builder
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
