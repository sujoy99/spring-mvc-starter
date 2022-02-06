package com.starter.dto;

import com.starter.entity.Pizza;
import com.starter.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.starter.enums.Status.PENDING;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;
    private Long pizzaId;
    private Double pizzaPrice = 0.00;
    private Status status = PENDING;
    private Long[] toppingsId;

    public Pizza toEntity(){
        Pizza pizza = new Pizza();
        pizza.setPizzaId(pizzaId);
//        pizza.setPizzaName(pizzaName);
        pizza.setPizzaPrice(pizzaPrice);
//        pizza.setPizzaStatus(status);
        return pizza;
    }

}
