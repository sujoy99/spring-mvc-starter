package com.starter.decorator.myPizza;

public class PizzaImpl implements iPizza {

    private com.starter.entity.Pizza pizza;

    public PizzaImpl(com.starter.entity.Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getPizzaName();
    }

    @Override
    public Double getCost() {
        return pizza.getPizzaPrice();
    }

    public com.starter.entity.Pizza toEntity(){
        return pizza;
    }
}
