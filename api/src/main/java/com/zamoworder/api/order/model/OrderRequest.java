package com.zamoworder.api.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Email
    String email;

    @Min(1)
    @Max(1000)
    Integer quantity;

    @Pattern(regexp = "^[0-9]{2,8}$")
    String promoCode;
}
