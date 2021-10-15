package com.zamoworder.api.order

import com.zamoworder.api.order.model.OrderRequest
import com.zamoworder.api.order.repository.OrderRepository
import spock.lang.Specification

class OrderServiceTest extends Specification {

    def validator = Mock(OrderValidator)
    def repository = Mock(OrderRepository)
    def service = Spy(OrderService, constructorArgs: [validator, repository]) as OrderService
    def orderRequest = new OrderRequest("some@email.com", 123, "4253")

    def "calculates discount correctly"() {
        given:
            validator.isValidPromoCode(_) >> true
            service.isEligiblePromoCode(_) >> true
        when:
            def discount = service.getDiscount(orderRequest)
        then:
            discount == 4
    }

    def "should return no discount when promo code is already used"() {
        given:
            validator.isValidPromoCode(_) >> true
            service.isEligiblePromoCode(_) >> false
        when:
            def discount = service.getDiscount(orderRequest)
        then:
            discount == 0
    }

    def "should return no discount when promo code is not valid"() {
        given:
            validator.isValidPromoCode(_) >> false
            service.isEligiblePromoCode(_) >> false
        when:
            def discount = service.getDiscount(orderRequest)
        then:
            discount == 0
    }
}
