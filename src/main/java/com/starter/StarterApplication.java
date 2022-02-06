package com.starter;

import com.starter.entity.Toppings;
import com.starter.repository.ToppingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class StarterApplication implements CommandLineRunner {

	private final ToppingsRepository toppingsRepository;

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Toppings toppingsOne = new Toppings(1L, "Cheese", 50.0);
		Toppings toppingsTwo = new Toppings(2L, "Mushroom", 100.0);

		toppingsRepository.saveAll(Arrays.asList(toppingsOne, toppingsTwo));

	}
}
