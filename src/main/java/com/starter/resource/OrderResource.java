package com.starter.resource;


import com.starter.dto.OrderDTO;
import com.starter.entity.Pizza;
import com.starter.entity.Toppings;
import com.starter.helper.OrderHelper;
import com.starter.service.PizzaService;
import com.starter.service.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderResource {

    private final ToppingsService toppingsService;
    private final PizzaService pizzaService;
    private final OrderHelper orderHelper;

    @GetMapping("/")
    public String homePage(Model model) {

        List<Toppings> toppings = toppingsService.findAll();
        model.addAttribute("toppings", toppings);

        List<Pizza> pizzas = pizzaService.findAll();
        model.addAttribute("pizzas", pizzas);

        OrderDTO orderDTO = new OrderDTO();
        model.addAttribute("orderDTO", orderDTO);
        return "index";

    }

    @PostMapping("/save-pizza")
    public String savePizza(OrderDTO orderDTO) {

        Pizza pizza = orderDTO.toEntity();
        orderHelper.getToppings(orderDTO, pizza);
        pizzaService.savePizza(pizza);

        return "redirect:/";
    }

    @PostMapping("/edit-pizza")
    public String editPizza(OrderDTO orderDTO) {

        Pizza pizza = orderDTO.toEntity();
        orderHelper.getToppings(orderDTO, pizza);
        pizzaService.savePizza(pizza);

        return "redirect:/";
    }
}
