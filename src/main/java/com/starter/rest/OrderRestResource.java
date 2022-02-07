package com.starter.rest;

import com.starter.entity.Order;
import com.starter.entity.Pizza;
import com.starter.service.OrderService;
import com.starter.service.implementation.PizzaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
public class OrderRestResource {

    private final OrderService orderService;

    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Order>(orderService.findById(toppingsId).orElseThrow(() -> new RuntimeException("Not found")), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }
}
