package com.janlenart.springshop.api.dto;

import com.janlenart.springshop.bo.assemblers.CustomerAssembler;
import com.janlenart.springshop.bo.assemblers.ItemAssembler;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.NonNull;

import java.util.Set;

public class OrderDTOFactory {

    public static OrderInfoDTO createOrderInfoDto(@NonNull OrderInfo orderInfo) {

        CustomerDTO customerDTO = CustomerAssembler.writeDto(orderInfo.getCustomer());

        OrderInfoDTO orderInfoDTO = OrderInfoDTO.builder()
                .orderDateTime(orderInfo.getOrderDateTime())
                .status(orderInfo.getStatus())
                .totalPrice(orderInfo.getTotalPrice())
                .totalPriceCurrency(orderInfo.getTotalPriceCurrency())
                .customerDTO(customerDTO)
                .build();

        Set<ItemDTO> itemDTOS = ItemAssembler.writeListDto(orderInfo.getItems(), orderInfoDTO);

        orderInfoDTO.setItemDtos(itemDTOS);

        return orderInfoDTO;
    }
}
