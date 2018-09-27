package com.janlenart.springshop.api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerDTO {

    private String name;
    private String surname;
    private String pesel;
    private AddressDTO addressDTO;

    private CustomerDTO(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.pesel = builder.pesel;
        this.addressDTO = builder.addressDTO;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String pesel;
        private AddressDTO addressDTO;

        public CustomerDTO build() {
            return new CustomerDTO(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder pesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public Builder addressDTO(AddressDTO addressDTO) {
            this.addressDTO = addressDTO;
            return this;
        }
    }
}
