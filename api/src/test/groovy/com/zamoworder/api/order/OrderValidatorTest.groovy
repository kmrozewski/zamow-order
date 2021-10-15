package com.zamoworder.api.order

import com.zamoworder.api.order.model.OrderRequest
import spock.lang.Specification

class OrderValidatorTest extends Specification {

    def validator = new OrderValidator()

    def "should be #isValid for #promoCode"() {
        expect:
            isValid == validator.isValidPromoCode(getOrderRequest(promoCode))
        where:
            isValid | promoCode
            true    | "1234"
            true    | "123"
            true    | "007"
            true    | "00"
            true    | "00000000"
            false   | "000000000"
            false   | "0"
            false   | ""
            false   | "abcd"
            false   | null
    }

    private static def getOrderRequest(String promoCode) {
        return new OrderRequest("some@email.com", 123, promoCode)
    }
}