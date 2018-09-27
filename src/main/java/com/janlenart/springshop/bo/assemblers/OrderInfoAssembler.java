package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.CustomerDTO;
import com.janlenart.springshop.api.dto.ItemDTO;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.NonNull;

import java.util.List;

public class OrderInfoAssembler {

    public static OrderInfoDTO writeDto(@NonNull OrderInfo orderInfo) {

        CustomerDTO customerDTO = CustomerAssembler.writeDto(orderInfo.getCustomer());

        OrderInfoDTO orderInfoDTO = OrderInfoDTO.builder()
                .orderDateTime(orderInfo.getOrderDateTime())
                .status(orderInfo.getStatus())
                .totalPrice(orderInfo.getTotalPrice())
                .totalPriceCurrency(orderInfo.getTotalPriceCurrency())
                .customerDTO(customerDTO)
                .build();

        List<ItemDTO> itemDTOList = ItemAssembler.writeListDto(orderInfo.getItems(), orderInfoDTO);

        orderInfoDTO.setItemDTOList(itemDTOList);

        return orderInfoDTO;
    }

}
