package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.AddressDTO;
import com.janlenart.springshop.bo.domain.Address;
import lombok.NonNull;

public class AddressAssembler {

    public static AddressDTO writeDto(@NonNull Address address) {
        AddressDTO addressDTO = new AddressDTO();

//        addressDTO.setId(address.getId());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setHouseNr(address.getHouseNr());
        addressDTO.setApartmentNr(address.getApartmentNr());

        return addressDTO;
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
