package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    // Owner, pet .. 등 다양하게 사용될 메소드를 공통으로 빼놓기

    // lastName과 일치하는 한 명의 Owner 정보 반환
    Owner findByLastName(String lastName);

    // SQL 에서 LIKE 연산자를 활용한 lastName 검색 기능
    List<Owner> findAllByLastNameLike(String lastName);

    // ID 값으로 검색
    Owner findById(Long ownerId);

    // save
    Owner save(Owner owner);

//    // update
//    Owner update(Owner owner);
}
