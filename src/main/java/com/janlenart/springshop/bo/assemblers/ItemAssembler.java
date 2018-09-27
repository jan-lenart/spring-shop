package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.ItemDTO;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.domain.Item;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ItemAssembler {
    public static ItemDTO writeDto(@NonNull Item item, OrderInfoDTO orderInfoDTO) {

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

    public static Item unpackDto(@NonNull ItemDTO itemDTO, OrderInfo orderInfo) {
        Item item = new Item();

        item.setBarcode(itemDTO.getBarcode());
        item.setDescription(itemDTO.getDescription());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setPriceCurrency(itemDTO.getPriceCurrency());
        item.setQuantity(itemDTO.getQuantity());

        item.setOrderInfo(orderInfo);

        return item;
    }


    public static List<ItemDTO> writeListDto(@NonNull List<Item> itemList, OrderInfoDTO orderInfoDTO) {
        List<ItemDTO> itemDTOList = new ArrayList<>();

        for (Item item : itemList) {
            ItemDTO itemDTO = writeDto(item, orderInfoDTO);
            itemDTOList.add(itemDTO);
        }

        return itemDTOList;
    }

    public static List<Item> unpackListDto(@NonNull List<ItemDTO> itemDTOList, OrderInfo orderInfo) {
        List<Item> itemList = new ArrayList<>();

        for (ItemDTO itemDTO : itemDTOList) {
            Item item = unpackDto(itemDTO, orderInfo);
            itemList.add(item);
        }

        return itemList;
    }
}
