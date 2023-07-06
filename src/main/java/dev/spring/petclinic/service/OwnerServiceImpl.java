package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{ // Impl: Implement의 줄임 표현
    // -> OwnerService 인터페이스를 구현한 구현 클래스 OwnerServiceImpl
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }


    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Owner findById(Long ownerId) {
//        Optional<Owner> owner = ownerRepository.findById(ownerId);
//
//        if (owner.isPresent()) {// owner 값이 존재하면(null 값이 아니면)
//            return owner.get();
//        }
//        return null;

        // 위 코드를 한줄로 표현
        return ownerRepository.findById(ownerId).orElse(null);
    }
}
