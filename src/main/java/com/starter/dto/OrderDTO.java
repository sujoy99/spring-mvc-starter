package com.starter.dto;

import com.starter.entity.Pizza;
import com.starter.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.starter.enums.Status.PENDING;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long pizzaId;
    private String pizzaName;
    private Double pizzaPrice = 500.00;
    private Status status = PENDING;
    private Long toppingId;

    public Pizza toEntity(){
        Pizza pizza = new Pizza();
        pizza.setPizzaId(pizzaId);
        pizza.setPizzaName(pizzaName);
        pizza.setPizzaPrice(pizzaPrice);
//        pizza.setPizzaStatus(status);
        return pizza;
    }

}
