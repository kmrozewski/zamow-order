package com.zamoworder.api.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Email
    String email;

    @Min(1)
    @Max(1000)
    Integer quantity;

    String promoCode;
}
