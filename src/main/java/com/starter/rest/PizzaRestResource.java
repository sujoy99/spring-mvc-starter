package com.starter.rest;

import com.starter.entity.Pizza;
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
@RequestMapping("api/v1/pizza")
public class PizzaRestResource {

    private final PizzaServiceImpl pizzaService;

    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Pizza>(pizzaService.findById(toppingsId).orElseThrow(() -> new RuntimeException("Not found")), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST);
        }
    }
}
