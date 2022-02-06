package com.starter.service.implementation;

import com.starter.entity.Pizza;
import com.starter.repository.PizzaRepository;
import com.starter.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Optional<Pizza> findById(Long pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @Override
    @Transactional
    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

}
