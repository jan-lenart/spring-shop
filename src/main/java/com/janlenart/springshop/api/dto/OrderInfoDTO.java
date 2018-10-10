package com.janlenart.springshop.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.janlenart.springshop.bo.domain.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class OrderInfoDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDateTime;
    private float totalPrice;
    private String totalPriceCurrency;
    private OrderStatus status;
    private CustomerDTO customerDTO;
    private Set<ItemDTO> itemDTOs;

    void setItemDtos(Set<ItemDTO> itemDTOList) {
        this.itemDTOs = itemDTOList;
    }
}
