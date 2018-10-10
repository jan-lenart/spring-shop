package com.janlenart.springshop.bo.domain;

import com.janlenart.springshop.api.OrderCommand;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.assemblers.CustomerAssembler;
import com.janlenart.springshop.bo.assemblers.ItemAssembler;
import lombok.NonNull;

import java.util.List;
import java.util.Set;

public class OrderFactory {

    public static OrderInfo createOrderInfo(@NonNull OrderCommand orderCommand) {

        OrderInfoDTO dto = orderCommand.getOrderInfoDTO();

        Customer customer = CustomerAssembler.readDto(dto.getCustomerDTO());

        OrderInfo orderInfo = new OrderInfo(
                customer,
                dto.getOrderDateTime()
        );

        Set<Item> itemList = ItemAssembler.readListDto(dto.getItemDTOs(), orderInfo);

        orderInfo.addItems(itemList);

        return orderInfo;
    }
}
