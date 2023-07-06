package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    // lastName과 일치하는 한 명의 Owner 정보 반환
    Owner findByLastName(String lastName);

    // SQL에서 LIKE 연산자를 활용한 lastName 검색 기능
    List<Owner> findAllByLastNameLike(String lastName);

    Owner findById(Long ownerId);
}
