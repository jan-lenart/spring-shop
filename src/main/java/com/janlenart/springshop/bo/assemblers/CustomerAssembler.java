package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.AddressDTO;
import com.janlenart.springshop.api.dto.CustomerDTO;
import com.janlenart.springshop.bo.domain.Address;
import com.janlenart.springshop.bo.domain.Customer;
import lombok.NonNull;

public class CustomerAssembler {

    public static CustomerDTO writeDto(@NonNull Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        AddressDTO addressDTO = AddressAssembler.writeDto(customer.getShippingAddress());

        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setPesel(customer.getPesel());
        customerDTO.setSurname(customer.getSurname());

        customerDTO.setAddressDTO(addressDTO);

        return customerDTO;
    }

    public static Customer unpackDto(@NonNull CustomerDTO customerDTO) {
        Customer customer = new Customer();
        Address address = AddressAssembler.unpackDto(customerDTO.getAddressDTO());

        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setPesel(customerDTO.getPesel());
        customer.setSurname(customerDTO.getSurname());

        customer.setShippingAddress(address);

        return customer;
    }
}
