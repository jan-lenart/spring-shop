package com.janlenart.springshop.bo.assemblers

import com.janlenart.springshop.api.dto.AddressDTO
import com.janlenart.springshop.bo.domain.Address
import spock.lang.Specification

class AddressAssemblerTest extends Specification {

    private static final String CITY = "NY"
    private static final String STREET = "Long"
    private static final int HOUSE_NR = 1
    private static final int APARTMENT_NR = 2

    def "WriteDto"() {
        given:
        Address address = new Address(CITY, STREET, HOUSE_NR, APARTMENT_NR)

        when:
        AddressDTO dto = AddressAssembler.writeDto(address)

        then:
        dto.city == address.city
        dto.street == address.street
        dto.houseNr == address.houseNr
        dto.apartmentNr == address.apartmentNr
    }

    def "ReadDto"() {
        given:
        AddressDTO dto = new AddressDTO.Builder()
                .city(CITY)
                .street(STREET)
                .houseNr(HOUSE_NR)
                .apartmentNr(APARTMENT_NR)
                .build()

        when:
        Address address = AddressAssembler.readDto(dto)

        then:
        dto.city == address.city
        dto.street == address.street
        dto.houseNr == address.houseNr
        dto.apartmentNr == address.apartmentNr
    }
}
