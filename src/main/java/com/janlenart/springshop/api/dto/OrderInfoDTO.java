package com.janlenart.springshop.api.dto;

import com.janlenart.springshop.bo.domain.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class OrderInfoDTO {

    private LocalDateTime orderDateTime;
    private float totalPrice;
    private String totalPriceCurrency;
    private OrderStatus status;
    private CustomerDTO customerDTO;
    private List<ItemDTO> itemDTOList;

    public void setItemDTOList(List<ItemDTO> itemDTOList) {
        this.itemDTOList = itemDTOList;
    }
}
