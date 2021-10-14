package com.zamoworder.api.order.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class OrderRequest {
    String email;
    Integer quantity;
    String promoCode;
}
