package com.janlenart.springshop.bo.domain

import com.janlenart.springshop.api.OrderCommand
import com.janlenart.springshop.api.dto.AddressDTO
import com.janlenart.springshop.api.dto.CustomerDTO
import com.janlenart.springshop.api.dto.ItemDTO
import com.janlenart.springshop.api.dto.OrderInfoDTO
import spock.lang.Specification

class OrderFactoryTest extends Specification {
    private static final String NAME = "Jan"

    private static final String CITY = "NY"

    private static final float PRICE = 10.5f
    private static final int QUANTITY = 5

    private static final float TOTAL_PRICE = PRICE * QUANTITY
    private static final OrderStatus STATUS = OrderStatus.CREATED


    def "test createOrderInfo"() {
        given:
        AddressDTO addressDTO = new AddressDTO.Builder()
                .city(CITY)
                .build()

        CustomerDTO customerDTO = new CustomerDTO.Builder()
                .name(NAME)
                .addressDTO(addressDTO)
                .build()

        OrderInfoDTO dto = new OrderInfoDTO.OrderInfoDTOBuilder()
                .totalPrice(TOTAL_PRICE)
                .status(STATUS)
                .customerDTO(customerDTO)
                .build()


        Set<ItemDTO> itemDTOS = new HashSet<>()
        ItemDTO itemDTO = new ItemDTO.ItemDTOBuilder()
                .price(PRICE)
                .quantity(QUANTITY)
                .orderInfoDTO(dto)
                .build()
        itemDTOS.add(itemDTO)

        dto.setItemDtos(itemDTOS)

        OrderCommand orderCommand = new OrderCommand(dto)

        when:

        OrderInfo orderInfo = OrderFactory.createOrderInfo(orderCommand)

        then:
        orderInfo.status == STATUS
        orderInfo.totalPrice == TOTAL_PRICE
        orderInfo.items.size() == 1
        orderInfo.customer.name == NAME
        orderInfo.customer.shippingAddress.city == CITY
    }

}
