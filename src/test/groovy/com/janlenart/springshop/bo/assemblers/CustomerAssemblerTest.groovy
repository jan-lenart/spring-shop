package com.janlenart.springshop.bo.assemblers

import com.janlenart.springshop.api.dto.AddressDTO
import com.janlenart.springshop.api.dto.CustomerDTO
import com.janlenart.springshop.bo.domain.Address
import com.janlenart.springshop.bo.domain.Customer
import spock.lang.Specification

class CustomerAssemblerTest extends Specification {

    private static final String NAME = "Jan"
    private static final String SURNAME = "Lenart"
    private static final String PESEL = "2000"
    private static final Address SHIPPING_ADDRESS = new Address()

    def "WriteDto"() {
        given:
        Customer customer = new Customer(NAME, SURNAME, PESEL, SHIPPING_ADDRESS)

        when:
        CustomerDTO dto = CustomerAssembler.writeDto(customer)

        then:
        dto.name == customer.name
        dto.surname == customer.surname
        dto.pesel == customer.pesel
    }

    def "ReadDto"() {
        given:
        CustomerDTO dto = new CustomerDTO.Builder()
                .name(NAME)
                .surname(SURNAME)
                .pesel(PESEL)
                .addressDTO(new AddressDTO())
                .build()

        when:
        Customer customer = CustomerAssembler.readDto(dto)

        then:
        dto.name == customer.name
        dto.surname == customer.surname
        dto.pesel == customer.pesel
    }
}
