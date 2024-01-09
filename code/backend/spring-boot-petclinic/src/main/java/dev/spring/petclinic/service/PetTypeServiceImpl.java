package dev.spring.petclinic.service;

import dev.spring.petclinic.model.PetType;
import dev.spring.petclinic.repository.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService{

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        super();
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    @Override
    public PetType findById(Long petTypeId) {
        return petTypeRepository.findById(petTypeId).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return null;
    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
