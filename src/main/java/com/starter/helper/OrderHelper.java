package com.starter.helper;

import com.starter.dto.OrderDTO;
import com.starter.entity.Order;
import com.starter.entity.OrderDetail;
import com.starter.entity.Pizza;
import com.starter.entity.Toppings;
import com.starter.service.PizzaService;
import com.starter.service.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderHelper {

    private final ToppingsService toppingsService;
    private final PizzaService pizzaService;

    public void setOrderDetails(OrderDTO orderDTO, Order order) {
        Pizza pizza = pizzaService.findById(orderDTO.getPizzaId()).get();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Arrays.asList(orderDTO.getToppingsId()).forEach(toppingsId -> {
            Toppings toppings = toppingsService.findById(toppingsId).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPizza(pizza);
            orderDetail.setToppings(toppings);
            orderDetails.add(orderDetail);
        });
        order.setOrderDetails(orderDetails);
    }

    public void updateOrderDetails(OrderDTO orderDTO, Order order) {
        order.getOrderDetails().clear();
        Pizza pizza = pizzaService.findById(orderDTO.getPizzaId()).get();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Arrays.asList(orderDTO.getToppingsId()).forEach(toppingsId -> {
            Toppings toppings = toppingsService.findById(toppingsId).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPizza(pizza);
            orderDetail.setToppings(toppings);
            orderDetails.add(orderDetail);
        });
        order.getOrderDetails().addAll(orderDetails);
    }
}
