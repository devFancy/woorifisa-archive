package dev.spring.petclinic.repository;

import dev.spring.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
    /*
    * CrudRepository : CRUD 관련 처리 작업을 정의해놓은 메서드
    *
    * Servlet/JSP 학습할 때 어떤 자바클래스를 Servlet으로 만들려면?
    * HttpServlet을 상속
    *
    * 동일하게 CRUD 관련 작업이 정의된 인터페이스가 이미 있음(스프링 데이터 JPA에서 제공)
    * 따라서 개발자는 CRUD 작업이 필요한 경울 CrudRepository를 상속받으면 되고,
    * 페이징, 정렬 처리 등의 작업이 필요한 경우 JpaRepository를 상속받아서 사용하면 됨
    */

    // lastName과 일치하는 한 명의 Owner 정보 반환
    Owner findByLastName(String lastName);

    // SQL에서 LIKE 연산자를 활용한 lastName 검색 기능
    // 쿼리 메서드 - 메서드의 이름만 규칙에 맞게 작성하면, 그에 해당하는 SQL쿼리가 작성됨
    List<Owner> findAllByLastNameLike(String lastName);

//    // ID 값으로 검색
//    @Override
//    Optional<Owner> findById(Long aLong);
//
//    @Override
//    <S extends Owner> S save(S entity); // ServiceImpl 에서 바로 CrudRepository를 사용 가능 , 이처럼 따로 선언 불필요
}