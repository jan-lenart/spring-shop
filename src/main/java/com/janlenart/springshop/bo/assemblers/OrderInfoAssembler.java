package com.janlenart.springshop.bo.assemblers;

import com.janlenart.springshop.api.dto.CustomerDTO;
import com.janlenart.springshop.api.dto.ItemDTO;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import com.janlenart.springshop.bo.domain.Customer;
import com.janlenart.springshop.bo.domain.Item;
import com.janlenart.springshop.bo.domain.OrderInfo;
import lombok.NonNull;

import java.util.List;

public class OrderInfoAssembler {
    public static OrderInfoDTO writeDto(@NonNull OrderInfo orderInfo) {
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        CustomerDTO customerDTO = CustomerAssembler.writeDto(orderInfo.getCustomer());
        List<ItemDTO> itemDTOList = ItemAssembler.writeListDto(orderInfo.getItems(), orderInfoDTO);

//        orderInfoDTO.setId(orderInfo.getId());
        orderInfoDTO.setOrderDateTime(orderInfo.getOrderDateTime());
        orderInfoDTO.setStatus(orderInfo.getStatus());
        orderInfoDTO.setTotalPrice(orderInfo.getTotalPrice());
        orderInfoDTO.setTotalPriceCurrency(orderInfo.getTotalPriceCurrency());

        orderInfoDTO.setCustomerDTO(customerDTO);
        orderInfoDTO.setItemDTOList(itemDTOList);

        return orderInfoDTO;
    }

    public static OrderInfo unpackDto(@NonNull OrderInfoDTO orderInfoDTO) {
        OrderInfo orderInfo = new OrderInfo();
        Customer customer = CustomerAssembler.unpackDto(orderInfoDTO.getCustomerDTO());
        List<Item> itemList = ItemAssembler.unpackListDto(orderInfoDTO.getItemDTOList(), orderInfo);

//        orderInfo.setId(orderInfoDTO.getId());
        orderInfo.setOrderDateTime(orderInfoDTO.getOrderDateTime());
        orderInfo.setTotalPrice(orderInfoDTO.getTotalPrice());
        orderInfo.setStatus(orderInfoDTO.getStatus());
        orderInfo.setTotalPriceCurrency(orderInfoDTO.getTotalPriceCurrency());

        orderInfo.setCustomer(customer);
        orderInfo.setItems(itemList);

        return orderInfo;
    }
}
