package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.AddressDTO;
import com.janlenart.springshop.bo.domain.Address;
import lombok.NonNull;

class AddressAssembler {

    static AddressDTO writeDto(@NonNull Address address) {

        return new AddressDTO.Builder()
                .city(address.getCity())
                .street(address.getStreet())
                .houseNr(address.getHouseNr())
                .apartmentNr(address.getApartmentNr())
                .build();
    }

    static Address readDto(@NonNull AddressDTO dto) {

        return new Address(
                dto.getCity(),
                dto.getStreet(),
                dto.getHouseNr(),
                dto.getApartmentNr()
        );

    }
}
