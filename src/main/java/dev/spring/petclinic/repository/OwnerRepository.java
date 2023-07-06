package dev.spring.petclinic.repository;
import dev.spring.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    // lastName과 일치하는 한 명의 Owner 정보 반환
    Owner findByLastName(String lastName);

    // SQL에서 LIKE 연산자를 활용한 lastName 검색 기능
    // 쿼리 메서드 - 메서드의 이름만 규칙에 맞게 작성하면 그에 해당하는 SQL 쿼리가 작성됨
    List<Owner> findAllByLastNameLike(String lastName);

    // save()
    // deleteById() 등을 상속받은 상태

}
