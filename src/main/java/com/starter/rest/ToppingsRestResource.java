package com.starter.rest;

import com.starter.decorator.decor.ToppingsImpl;
import com.starter.decorator.myPizza.iPizza;
import com.starter.decorator.myPizza.PizzaImpl;
import com.starter.dto.DataDTO;
import com.starter.entity.Toppings;
import com.starter.service.PizzaService;
import com.starter.service.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/toppings")
public class ToppingsRestResource {

    private final ToppingsService toppingsService;
    private final PizzaService pizzaService;

    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Toppings> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Toppings>(toppingsService.findById(toppingsId).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Toppings>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/find/{id}/{pizzaId}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> findById(@PathVariable("id") Long toppingsId, @PathVariable("pizzaId") Long pizzaId) {

        try {

//            PizzaDecor pizzaDecor = new PizzaImpl(1L, "pizza1", 100.0);
//            ToppingsImpl toppings = new ToppingsImpl(pizzaDecor, 30.0);

            com.starter.entity.Pizza pizza = pizzaService.findById(pizzaId).get();
            iPizza pizzaDecor = new PizzaImpl(pizza);
            Toppings toppingsEntity = toppingsService.findById(toppingsId).get();
            ToppingsImpl toppings = new ToppingsImpl(pizzaDecor, toppingsEntity);

            return new ResponseEntity<Double>(toppings.getCost(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> findBy(@RequestBody DataDTO data) {

        try {

            com.starter.entity.Pizza pizza = pizzaService.findById(data.getPizzaId()).get();
            iPizza pizzaDecor = new PizzaImpl(pizza);

            for (Long id :
                    data.getToppingsId()) {
                Toppings toppingsEntity = toppingsService.findById(id).get();
                pizzaDecor = new ToppingsImpl(pizzaDecor, toppingsEntity);
            }


            return new ResponseEntity<Double>( pizzaDecor.getCost(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
        }
    }
}
