package com.starter.rest;

import com.starter.entity.Toppings;
import com.starter.service.ToppingsService;
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
@RequestMapping("api/v1/toppings")
public class ToppingsRestResource {

    private final ToppingsService toppingsService;

    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Toppings> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Toppings>(toppingsService.findById(toppingsId).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Toppings>(HttpStatus.BAD_REQUEST);
        }
    }
}
