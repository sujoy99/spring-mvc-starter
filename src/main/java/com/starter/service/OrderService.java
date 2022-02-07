package com.starter.service;

import com.starter.entity.Order;
import com.starter.entity.Pizza;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(Long orderId);

    void saveOrder(Order order);
}
