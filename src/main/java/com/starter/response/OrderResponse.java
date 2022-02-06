package com.starter.response;

import com.starter.entity.Order;
import com.starter.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponse {

    private Long orderId;
    private Long pizzaId;
    private String pizzaName;
    private Double totalPrice;
    private Status orderStatus;

    public static OrderResponse response(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setPizzaId(order.getOrderDetails().get(0).getPizza().getPizzaId());
        orderResponse.setPizzaName(order.getOrderDetails().get(0).getPizza().getPizzaName());
        orderResponse.setTotalPrice(order.getTotalPrice());
        orderResponse.setOrderStatus(order.getOrderStatus());
        return orderResponse;
    }
}
