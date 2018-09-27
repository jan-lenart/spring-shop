package com.janlenart.springshop.api.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ItemDTO {

    private String name;
    private String description;
    private String barcode;
    private float price;
    private int quantity;
    private String priceCurrency;

    @JsonBackReference
    private OrderInfoDTO orderInfoDTO;

}
