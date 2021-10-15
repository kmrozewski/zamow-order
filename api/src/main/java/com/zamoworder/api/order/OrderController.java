package com.zamoworder.api.order;

import com.zamoworder.api.order.model.OrderRequest;
import com.zamoworder.api.order.model.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/order", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    final OrderService service;
    final OrderValidator validator;

    @PostMapping("/create")
    public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderRequest orderRequest) {
        //TODO: validation of the quantity
        var response = service.createOrder(orderRequest);

        return new ResponseEntity<OrderDetail>(response, OK);
    }
}
