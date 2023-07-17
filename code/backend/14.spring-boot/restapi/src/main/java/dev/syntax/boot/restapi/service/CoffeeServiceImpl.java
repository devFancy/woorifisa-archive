package dev.syntax.boot.restapi.service;

import dev.syntax.boot.restapi.domain.Coffee;
import dev.syntax.boot.restapi.repository.CoffeeRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    @Override
    public void save(Coffee coffee) {
        coffeeRepository.save(coffee);
    }

    @Override
    public Coffee findById(String id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        coffeeRepository.deleteById(id);
    }
}
