package com.janlenart.springshop.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class OrderCommand {

    private int id;
}
