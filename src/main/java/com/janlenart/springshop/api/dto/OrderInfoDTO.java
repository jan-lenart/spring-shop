package com.janlenart.springshop.api.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderInfoDTO {

    private Integer id;
    private LocalDateTime orderDateTime;
    private float totalPrice;
    private String totalPriceCurrency;
    private String status;

    @JsonProperty("customer")
    private CustomerDTO customerDTO;

    @JsonProperty("itemList")
    @JsonManagedReference
    private List<ItemDTO> itemDTOList;
}
