package com.janlenart.springshop.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddressDTO {

    private String city;
    private String street;
    private int houseNr;
    private int apartmentNr;

    private AddressDTO(Builder builder) {
        this.city = builder.city;
        this.street = builder.street;
        this.houseNr = builder.houseNr;
        this.apartmentNr = builder.apartmentNr;
    }

    public static class Builder {
        private String city;
        private String street;
        private int houseNr;
        private int apartmentNr;

        public AddressDTO build() {
            return new AddressDTO(this);
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder houseNr(int houseNr) {
            this.houseNr = houseNr;
            return this;
        }

        public Builder apartmentNr(int apartmentNr) {
            this.apartmentNr = apartmentNr;
            return this;
        }

    }
}
