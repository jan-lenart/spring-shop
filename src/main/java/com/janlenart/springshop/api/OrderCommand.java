package com.janlenart.springshop.api;

import com.janlenart.springshop.api.dto.OrderInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCommand {

  private OrderInfoDTO orderInfoDTO;

}

