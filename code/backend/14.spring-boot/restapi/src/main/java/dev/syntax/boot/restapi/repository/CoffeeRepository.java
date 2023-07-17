package dev.syntax.boot.restapi.repository;

import dev.syntax.boot.restapi.domain.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    List<Coffee> findAll();
}
