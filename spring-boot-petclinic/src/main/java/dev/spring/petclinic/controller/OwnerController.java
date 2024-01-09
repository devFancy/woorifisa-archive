package dev.spring.petclinic.controller;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 * Servlet에서는 InsertController, ListController, 등 개별적으로 컨트롤러 작성
 * Spring에서는 Owner와 관련된 데이터 처리는 하나의 Controller에서 하는 편
 */

@RequestMapping("/owners") // localhost:8080/onwers로 요청이 올 경우 동작
@Controller // or @Component
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // /find 경로로 GET 요청이 왔을 경우 findOnwer가 호출되도록 작성, 테스트
    @GetMapping(path = "/find")
    public String findOwner(Model model) {

        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(HttpServletRequest request, Owner owner, Model model) {

        // 별도의 파라미터값 없이, /owners로 요청할 경우 모든 Owners 데이터 변환
        if (owner.getLastName() == null) {
            owner.setLastName(""); // 빈 값으로 검색할 수 있도록 공백 문자열 값 설정
        }

        /*
         * List<Owner>인 owners를 가지고 조건식으로 분기
         * 조건 1. 해당하는 owner가 없을 경우, - owners/findOwners 로 페이지 이동
         * 조건 2. owner가 1명일 경우, 경로에 owners/{ownerId값}
         * 조건 3. 2명 이상의 owner일 경우
         */

        // lastName으로 Owner 조회
        List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        // key값으로 listOwners 지정, value값으로 owners
        model.addAttribute("listOwners", owners);

        if (owners.isEmpty()) {
            return "redirect:/owners/find";
        } else if (owners.size() == 1) {
            owner = owners.get(0);
            return "redirect:/owners/" + owner.getId(); // showOwner()로 요청
        }
        return "owners/ownersList";
    }

    @GetMapping("/{ownerId}") // localhost:8080/owners/1
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        // ModelAndView 객체 생성, view단 연결
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("owners/ownerDetails");

        // id값에 일치하는 1명의 owner 데이터 조회
        Owner owner = ownerService.findById(ownerId);
        mnv.addObject(owner);

        return mnv;
    }

    // 추가할 수 있는 form으로 이동
    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());

        return "owners/createOrUpdateOwnerForm";
    }

    // owner 객체를 DB에 추가하는 기능으로 동작할 메서드
    @PostMapping("/new")
    public String processCreationForm(Owner owner) {

        // form으로 부터 전달 받은 값을 service에 넘겨서 DB 등록 처리 수행
        Owner savedOwner = ownerService.save(owner);

        // redirect : DB에 넣은 데이터인 Owner에
        return "redirect:/owners/" + savedOwner.getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);

        model.addAttribute("owner", owner);

        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(Owner owner, @PathVariable Long ownerId) {
        /*
        owner = Owner.builder()
                .id(ownerId)
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .pets(owner.getPets())
                .build();
         */
        owner.setId(ownerId);
        Owner updateOwner = ownerService.save(owner);

        // redirect : DB에 넣은 데이터인 Owner에
        return "redirect:/owners/" + updateOwner.getId();
    }
}