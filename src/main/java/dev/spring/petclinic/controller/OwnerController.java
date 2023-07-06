package dev.spring.petclinic.controller;


import dev.spring.petclinic.model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller// or @Component
public class OwnerController {

    // find 경로로 GET 요청이 왔을 경우 findOwner 가 호출되도록 작성, 테스트
    @GetMapping(path = "/find")
    public String findOwner(Model model) {
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }
}
