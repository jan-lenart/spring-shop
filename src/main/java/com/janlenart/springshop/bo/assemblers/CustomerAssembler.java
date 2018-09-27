package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.AddressDTO;
import com.janlenart.springshop.api.dto.CustomerDTO;
import com.janlenart.springshop.bo.domain.Address;
import com.janlenart.springshop.bo.domain.Customer;
import lombok.NonNull;

public class CustomerAssembler {

    public static CustomerDTO writeDto(@NonNull Customer customer) {
        AddressDTO addressDTO = AddressAssembler.writeDto(customer.getShippingAddress());

        return new CustomerDTO.Builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .pesel(customer.getPesel())
                .addressDTO(addressDTO)
                .build();
    }

    public static Customer readDto(@NonNull CustomerDTO dto) {

        Address address = AddressAssembler.readDto(dto.getAddressDTO());

        return Customer.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .pesel(dto.getPesel())
                .shippingAddress(address)
                .build();

    }
}
