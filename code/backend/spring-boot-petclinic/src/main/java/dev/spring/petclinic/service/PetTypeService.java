package dev.spring.petclinic.service;

import dev.spring.petclinic.model.PetType;

import java.util.List;

public interface PetTypeService extends CrudService<PetType, Long> {

    // T(type) 을 활용하여 일반화된 메서드로 적용
    List<PetType> findAll();

    PetType findById(Long petTypeId);

}
