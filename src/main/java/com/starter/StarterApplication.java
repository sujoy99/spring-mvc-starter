package com.starter;

import com.starter.entity.Pizza;
import com.starter.entity.Toppings;
import com.starter.repository.PizzaRepository;
import com.starter.repository.ToppingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class StarterApplication implements CommandLineRunner {

	private final PizzaRepository pizzaRepository;
	private final ToppingsRepository toppingsRepository;

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Toppings toppingsOne = new Toppings(1L, "Sausage", 30.0);
		Toppings toppingsTwo = new Toppings(2L, "Mushroom", 40.0);
		Toppings toppingsThree = new Toppings(3L, "Peeperoni", 60.0);

		toppingsRepository.saveAll(Arrays.asList(toppingsOne, toppingsTwo, toppingsThree));

		Pizza pizzaOne = new Pizza(1L, "ThickCrustPizza", 500.0);
		Pizza pizzaTwo = new Pizza(2L, "ThinCrustPizza", 400.0);
		Pizza pizzaThree = new Pizza(3L, "CheeseCrustPizza", 600.0);

		pizzaRepository.saveAll(Arrays.asList(pizzaOne, pizzaTwo, pizzaThree));

	}
}
