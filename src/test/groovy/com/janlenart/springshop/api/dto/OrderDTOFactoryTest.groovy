package com.janlenart.springshop.api.dto

import com.janlenart.springshop.api.OrderCommand
import com.janlenart.springshop.bo.domain.OrderFactory
import com.janlenart.springshop.bo.domain.OrderInfo
import com.janlenart.springshop.bo.domain.OrderStatus
import spock.lang.Specification

class OrderDTOFactoryTest extends Specification {

    private static final String NAME = "Jan"

    private static final String CITY = "NY"

    private static final float PRICE = 10.5f
    private static final int QUANTITY = 5

    private static final float TOTAL_PRICE = PRICE * QUANTITY
    private static final String TOTAL_PRICE_CURRENCY = "PLN"
    private static final OrderStatus STATUS = OrderStatus.CREATED

    def "CreateOrderInfoDto"() {
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
                .totalPriceCurrency(TOTAL_PRICE_CURRENCY)
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

        OrderInfo orderInfo = OrderFactory.createOrderInfo(orderCommand)

        when:
        OrderInfoDTO orderInfoDTO = OrderDTOFactory.createOrderInfoDto(orderInfo)

        then:
        orderInfoDTO.status == STATUS
        orderInfoDTO.totalPrice == TOTAL_PRICE
        orderInfoDTO.totalPriceCurrency == TOTAL_PRICE_CURRENCY
        orderInfoDTO.itemDTOs.size() == 1
        orderInfoDTO.customerDTO.name == NAME
        orderInfoDTO.customerDTO.addressDTO.city == CITY

    }
}
