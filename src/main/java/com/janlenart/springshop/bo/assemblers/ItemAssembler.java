package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.ItemDTO;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.domain.Item;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

public class ItemAssembler {
    private static ItemDTO writeDto(@NonNull Item item, OrderInfoDTO orderInfoDTO) {

        return ItemDTO.builder()
                .barcode(item.getBarcode())
                .description(item.getDescription())
                .name(item.getName())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .priceCurrency(item.getPriceCurrency())
                .orderInfoDTO(orderInfoDTO)
                .build();

    }

    private static Item readDto(@NonNull ItemDTO dto, OrderInfo orderInfo) {

        return new Item(
                dto.getName(),
                dto.getDescription(),
                dto.getBarcode(),
                dto.getPrice(),
                dto.getQuantity(),
                dto.getPriceCurrency(),
                orderInfo
        );

    }


    public static Set<ItemDTO> writeListDto(@NonNull Set<Item> items, OrderInfoDTO orderInfoDTO) {
        Set<ItemDTO> itemDTOList = new HashSet<>();

        for (Item item : items) {
            ItemDTO itemDTO = writeDto(item, orderInfoDTO);
            itemDTOList.add(itemDTO);
        }

        return itemDTOList;
    }

    public static Set<Item> readListDto(@NonNull Set<ItemDTO> itemDTOS, OrderInfo orderInfo) {
        Set<Item> itemList = new HashSet<>();

        for (ItemDTO itemDTO : itemDTOS) {
            Item item = readDto(itemDTO, orderInfo);
            itemList.add(item);
        }

        return itemList;
    }
}
