package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Pet;
import dev.spring.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        super();
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
