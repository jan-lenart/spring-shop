package com.janlenart.springshop.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.janlenart.springshop.api.dto.AddressDTO;
import com.janlenart.springshop.api.dto.CustomerDTO;
import com.janlenart.springshop.api.dto.ItemDTO;
import com.janlenart.springshop.api.dto.OrderInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class OrderCommand {

    @JsonProperty("order")
    private OrderInfoDTO orderInfoDTO;
    @JsonProperty("customer")
    private CustomerDTO customerDTO;
    @JsonProperty("shippingAddress")
    private AddressDTO addressDTO;
    @JsonProperty("itemList")
    private List<ItemDTO> itemDTOList;


    public OrderCommand() {
        this.orderInfoDTO = new OrderInfoDTO();
        this.customerDTO = new CustomerDTO();
        this.addressDTO = new AddressDTO();
        this.itemDTOList = new ArrayList<>();

    }

}

