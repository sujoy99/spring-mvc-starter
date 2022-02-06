package com.starter.dto;

import com.starter.entity.Order;
import com.starter.entity.Pizza;
import com.starter.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.starter.enums.Status.PENDING;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;
    private Long pizzaId;
    private Double totalPrice = 0.00;
    private Status status = PENDING;
    private Long[] toppingsId;

    public Order toEntity() {
        Order order = new Order();
        order.setOrderStatus(status);
        order.setTotalPrice(totalPrice);
        return order;
    }

}
