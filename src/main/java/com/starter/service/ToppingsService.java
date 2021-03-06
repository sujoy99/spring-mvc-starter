package com.starter.service;

import com.starter.entity.Toppings;
import com.starter.repository.ToppingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToppingsService {

    private final ToppingsRepository toppingsRepository;

    public List<Toppings> findAll() {
        return toppingsRepository.findAll();
    }

    public Optional<Toppings> findById(Long toppingsId) {
        return toppingsRepository.findById(toppingsId);
    }
}
