package com.zamoworder.api.order.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "order_detail")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NonNull
    private String orderNumber;

    @NonNull
    private String email;

    @NonNull
    private String promoCode;

    @NonNull
    private Integer quantity;
}
