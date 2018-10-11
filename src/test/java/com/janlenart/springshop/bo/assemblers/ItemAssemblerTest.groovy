package com.janlenart.springshop.bo.assemblers

import com.janlenart.springshop.api.dto.ItemDTO
import com.janlenart.springshop.api.dto.OrderInfoDTO
import com.janlenart.springshop.bo.domain.Item
import com.janlenart.springshop.bo.domain.OrderInfo
import spock.lang.Specification

class ItemAssemblerTest extends Specification {

    private static final String NAME = "Item"
    private static final String DESCRIPTION = "Desc"
    private static final String BARCODE = "Code"
    private static final float PRICE = 10.5f
    private static final int QUANTITY = 5
    private static final String PRICE_CURRENCY = "PLN"
    private static final OrderInfo ORDER_INFO = new OrderInfo()
    private static final OrderInfoDTO ORDER_INFO_DTO = new OrderInfoDTO()


    def "WriteListDto"() {
        given:
        Set<Item> items = new HashSet<>()
        Item item = new Item(NAME, DESCRIPTION, BARCODE, PRICE, QUANTITY, PRICE_CURRENCY, ORDER_INFO)
        items.add(item)

        when:
        Set<ItemDTO> dtos = ItemAssembler.writeListDto(items, ORDER_INFO_DTO)

        then:
        dtos[0].name == item.name
        dtos[0].description == item.description
        dtos[0].barcode == item.barcode
        dtos[0].price == item.price
        dtos[0].quantity == item.quantity
        dtos[0].priceCurrency == item.priceCurrency

    }

    def "ReadListDto"() {
        given:
        Set<ItemDTO> dtos = new HashSet<>()
        ItemDTO itemDTO = new ItemDTO.ItemDTOBuilder()
                .name(NAME)
                .description(DESCRIPTION)
                .barcode(BARCODE)
                .price(PRICE)
                .quantity(QUANTITY)
                .priceCurrency(PRICE_CURRENCY)
                .orderInfoDTO(ORDER_INFO_DTO)
                .build()
        dtos.add(itemDTO)

        when:
        Set<Item> items = ItemAssembler.readListDto(dtos, ORDER_INFO)

        then:
        items[0].name == itemDTO.name
        items[0].description == itemDTO.description
        items[0].barcode == itemDTO.barcode
        items[0].price == itemDTO.price
        items[0].quantity == itemDTO.quantity
        items[0].priceCurrency == itemDTO.priceCurrency
    }
}
