package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long>{

    // ID 값으로 검색
    Pet findById(Long petId);

}
