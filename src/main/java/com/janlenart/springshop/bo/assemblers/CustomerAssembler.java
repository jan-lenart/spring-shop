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

    public static Customer unpackDto(@NonNull CustomerDTO customerDTO) {
        Customer customer = new Customer();
        Address address = AddressAssembler.unpackDto(customerDTO.getAddressDTO());

//        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setPesel(customerDTO.getPesel());
        customer.setSurname(customerDTO.getSurname());

        customer.setShippingAddress(address);

        return customer;
    }
}
