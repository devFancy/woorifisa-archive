package dev.spring.petclinic.service;

import java.util.List;

//
public interface CrudService<T, ID> {

    // T(type) 을 활용하여 일반화된 메서드로 적용
    List<T> findAll();

    T findById(ID id);

    // save(엔티티)
    T save(T object);

    // delete(엔티티)
    void delete(T object);

    // deleteById
    void deleteById(ID id);
}
