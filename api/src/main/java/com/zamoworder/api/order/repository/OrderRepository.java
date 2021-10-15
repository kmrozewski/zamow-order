package com.zamoworder.api.order.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderDetailEntity, Long> {

    List<OrderDetailEntity> findByPromoCode(String promoCode);
}
