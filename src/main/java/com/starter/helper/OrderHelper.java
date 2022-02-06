package com.starter.helper;

import com.starter.dto.OrderDTO;
import com.starter.entity.Pizza;
import com.starter.entity.Toppings;
import com.starter.service.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderHelper {

    private final ToppingsService toppingsService;

    public void getToppings(OrderDTO orderDTO, Pizza pizza){
        Toppings toppings = toppingsService.findById(orderDTO.getToppingId()).get();
        pizza.setToppings(toppings);
    }
}
