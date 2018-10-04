package com.janlenart.springshop.bo.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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

    public Customer(String name, String surname, String pesel, Address shippingAddress) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.shippingAddress = shippingAddress;
    }


}
