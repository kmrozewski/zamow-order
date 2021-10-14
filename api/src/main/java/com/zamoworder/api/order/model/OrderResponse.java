package com.zamoworder.api.order.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class OrderResponse {
    String orderNumber;
    String email;
    Integer quantity;
    Integer discount;
}
