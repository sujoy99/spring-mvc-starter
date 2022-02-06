package com.starter.service;

import com.starter.entity.Order;
import com.starter.entity.Pizza;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void saveOrder(Order order);
}
