package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.NonNull;

public class OrderInfoAssembler {
    public static OrderInfoDTO writeDto(@NonNull OrderInfo orderInfo) {
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();

        orderInfoDTO.setId(orderInfo.getId());
        orderInfoDTO.setOrderDateTime(orderInfo.getOrderDateTime());
        orderInfoDTO.setStatus(orderInfo.getStatus());
        orderInfoDTO.setTotalPrice(orderInfo.getTotalPrice());
        orderInfoDTO.setTotalPriceCurrency(orderInfo.getTotalPriceCurrency());

        orderInfoDTO.setCustomer(orderInfo.getCustomer());
        orderInfoDTO.setItemList(orderInfo.getItems());

        return orderInfoDTO;
    }

    public static OrderInfo unpackDto(@NonNull OrderInfoDTO orderInfoDTO) {
        OrderInfo orderInfo = new OrderInfo();

        orderInfo.setId(orderInfoDTO.getId());
        orderInfo.setOrderDateTime(orderInfoDTO.getOrderDateTime());
        orderInfo.setTotalPrice(orderInfoDTO.getTotalPrice());
        orderInfo.setStatus(orderInfoDTO.getStatus());
        orderInfo.setTotalPriceCurrency(orderInfoDTO.getTotalPriceCurrency());

        orderInfo.setCustomer(orderInfoDTO.getCustomer());
        orderInfo.setItems(orderInfoDTO.getItemList());

        return orderInfo;
    }
}
