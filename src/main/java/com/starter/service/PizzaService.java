package com.starter.service;

import com.starter.entity.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    List<Pizza> findAll();

    Optional<Pizza> findById(Long pizzaId);

    void savePizza(Pizza pizza);
}
