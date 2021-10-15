package com.zamoworder.api.order;

import com.zamoworder.api.order.model.OrderRequest;
import com.zamoworder.api.order.model.OrderDetail;
import com.zamoworder.api.order.repository.OrderDetailEntity;
import com.zamoworder.api.order.repository.OrderRepository;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.apache.commons.lang3.RandomStringUtils.random;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private static final int NO_DISCOUNT = 0;
    private static final boolean USE_NUMBERS = true;
    private static final boolean USE_LETTERS = USE_NUMBERS;
    private static final int ORDER_NUMBER_LENGTH = 12;
    private final OrderValidator validator;
    private final OrderRepository repository;

    @Transactional
    public OrderDetail createOrder(OrderRequest orderRequest) {
        var discount = getDiscount(orderRequest);
        var orderNumber = getOrderNumber();

        repository.save(new OrderDetailEntity(
                orderNumber,
                orderRequest.getEmail(),
                discount == 0 ? "" : orderRequest.getPromoCode(),
                orderRequest.getQuantity())
        );

        return new OrderDetail(orderNumber, orderRequest.getEmail(), orderRequest.getQuantity(), discount);
    }

    private Integer getDiscount(OrderRequest orderRequest) {
        return Try.of(() -> orderRequest)
                .filter(validator::isValidPromoCode)
                .onFailure(throwable -> log.debug("Promo code is not valid: {}", orderRequest))
                .map(OrderRequest::getPromoCode)
                .filter(this::isEligiblePromoCode)
                .onFailure(throwable -> log.debug("Promo code is already used: {}", orderRequest))
                .map(this::calculateDiscount)
                .getOrElse(NO_DISCOUNT);
    }

    @Transactional //TODO: check if this annotation is needed here
    boolean isEligiblePromoCode(String promoCode) {
        return repository.findByPromoCode(promoCode).isEmpty();
    }

    private Integer calculateDiscount(String promoCode) {
        return promoCode.length();
    }

    private String getOrderNumber() {
        return random(ORDER_NUMBER_LENGTH, USE_LETTERS, USE_NUMBERS).toUpperCase();
    }
}
