package com.starter.service.implementation;

import com.starter.entity.Order;
import com.starter.entity.Pizza;
import com.starter.repository.OrderRepository;
import com.starter.repository.PizzaRepository;
import com.starter.service.OrderService;
import com.starter.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) { orderRepository.save(order); }
}
