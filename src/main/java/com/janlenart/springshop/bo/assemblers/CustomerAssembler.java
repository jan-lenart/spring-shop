package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.CustomerDTO;
import com.janlenart.springshop.bo.domain.Customer;
import lombok.NonNull;

public class CustomerAssembler {

    public static CustomerDTO writeDto(@NonNull Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setPesel(customer.getPesel());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setAddress(customer.getShippingAddress());

        return customerDTO;
    }

    public static Customer unpackDto(@NonNull CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setId(customerDTO.getId());
        customer.setShippingAddress(customerDTO.getAddress());
        customer.setName(customerDTO.getName());
        customer.setPesel(customerDTO.getPesel());
        customer.setSurname(customerDTO.getSurname());

        return customer;
    }
}
