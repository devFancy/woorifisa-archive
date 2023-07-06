package dev.spring.petclinic.controller;


import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/owners")
@Controller// or @Component
public class OwnerController {

    private final OwnerServiceImpl ownerService;

    public OwnerController(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    // find 경로로 GET 요청이 왔을 경우 findOwner 가 호출되도록 작성, 테스트
    @GetMapping(path = "/find")
    public String findOwner(Model model) {
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, Model model) {
        // 별도의 피라미터 값 없이 /owners로 요청할 경우 모든 Owners 데이터 반환
        if(owner.getLastName() == null) {
            owner.setLastName(""); // 빈 값으로 검색할 수 있도록 공백 문자로 값 설정

        }
        // lastName 으로 Owner 조회
        List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName());

        /*
         * List<Owner> owners를 가지고 조건식으로 분기
         * 조건1. 해당하는 owner가 없을 경우 - owners/findOwners로 페이지 이동
         * 조건2. owner가 1명일 경우, 경로에 owners/{ownerId값}
         * 조건3. 2명 이상의 owner일 경우
         */
        // 조건1
        if(owners.isEmpty()) {
            return "owners/findOwners";
        } else if(owners.size() == 1) { // 조건2
            Owner singleOwner = owners.get(0);
            return "forward:/owners/" + singleOwner.getId();
        }

        // key 값으로 listOwners 지정, value 값으로 owners
        model.addAttribute("listOwners", owners);

        // 조건3
        return "owners/ownersList"; // showOwner()로 요청
    }

    @GetMapping("/{ownerId}")
    public String showOwner(Model model, @PathVariable("ownerId") Long ownerId) {
        // ownerId를 사용하여 Owner 정보를 조회하고, model에 추가하는 로직을 작성합니다.
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute("owner", owner);

        return "owners/ownerDetails"; // 적절한 뷰 페이지의 이름을 반환합니다.
    }
}
