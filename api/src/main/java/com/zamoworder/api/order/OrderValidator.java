package com.zamoworder.api.order;

import com.zamoworder.api.order.model.OrderRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderValidator {
    public boolean isValidPromoCode(OrderRequest orderRequest) {
        return Optional.ofNullable(orderRequest)
                .map(OrderRequest::getPromoCode)
                .filter(StringUtils::isNumeric)
                .map(this::hasCorrectLength)
                .orElse(false);
    }

    private boolean hasCorrectLength(String promoCode) {
        return promoCode.length() >= 2 && promoCode.length() <= 8;
    }
}
