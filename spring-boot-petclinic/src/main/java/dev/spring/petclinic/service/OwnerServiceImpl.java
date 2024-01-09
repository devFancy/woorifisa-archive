package dev.spring.petclinic.service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 구현체를 Bean으로 등록
public class OwnerServiceImpl implements OwnerService {
    // Impl: Implement의 줄임 표현
    // -> OwnerService 인터페이스를 구현한 구현 클래스 OwnerServiceImpl

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        super();
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
    public List<Owner> findAll() {
        return null;
    }

    @Override
    public Owner findById(Long ownerId) {
        // optional : 선택적인
        // Optional<Owner> owner = ownerRepository.findById(ownerId);
        // select 로 조회를 했지만, id 가 없을수도 있음 => 그럴때 Optional 사용
        // ownerRepository 는 dao 같은 것

        /*
            if(owner.isPresent()) {
                // owner 내부에 값이 존재한다면
                return owner.get(); // owner가 null값이 아니면
            }
            return null;
        */

        // 위 코드를 한줄로 표현 가능
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        // CrudRepository<T, ID> 에서의 save 메소드를 사용 (OwnerRepository가 CrudRepository를 상속 받았기 때문에 사용 가능)
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

}
