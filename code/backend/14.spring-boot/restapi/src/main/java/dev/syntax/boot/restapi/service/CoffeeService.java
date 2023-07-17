package dev.syntax.boot.restapi.service;

import dev.syntax.boot.restapi.domain.Coffee;

import java.util.List;


public interface CoffeeService {
        List<Coffee> findAll();
        void save(Coffee coffee);
        Coffee findById(String id);
        void deleteById(String id);
}
