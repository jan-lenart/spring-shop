package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.AddressDTO;
import com.janlenart.springshop.bo.domain.Address;
import lombok.NonNull;

public class AddressAssembler {

    public static AddressDTO writeDto(@NonNull Address address) {

        return new AddressDTO.Builder()
                .city(address.getCity())
                .street(address.getStreet())
                .houseNr(address.getHouseNr())
                .apartmentNr(address.getApartmentNr())
                .build();

    }

    public static Address unpackDto(@NonNull AddressDTO addressDTO) {

        Address address = new Address();

//        address.setId(addressDTO.getId());
        address.setApartmentNr(addressDTO.getApartmentNr());
        address.setCity(addressDTO.getCity());
        address.setHouseNr(addressDTO.getHouseNr());
        address.setStreet(addressDTO.getStreet());

        return address;
    }
}
