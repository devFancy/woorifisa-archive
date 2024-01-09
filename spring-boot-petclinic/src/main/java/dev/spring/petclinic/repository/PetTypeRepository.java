package dev.spring.petclinic.repository;

import dev.spring.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
    List<PetType> findAll();
}
