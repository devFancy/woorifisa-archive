package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.PetDTO;
import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.model.Pet;
import dev.spring.petclinic.model.PetType;
import dev.spring.petclinic.service.OwnerService;
import dev.spring.petclinic.service.PetService;
import dev.spring.petclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/owners/{ownerId}/pets")
@Controller
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model, @PathVariable Long ownerId) {
        Owner owner = ownerService.findById(ownerId);
        List<PetType> petType = petTypeService.findAll();

        model.addAttribute("pet", Pet.builder().build());
        model.addAttribute("owner", owner);
        model.addAttribute("petType", petType);

        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@PathVariable Long ownerId, PetDTO petDTO) {
        PetType type = petTypeService.findById(petDTO.getType());
        Owner owner = ownerService.findById(ownerId);

        Pet newPet = Pet.builder()
                .name(petDTO.getName())
                .petType(type)
                .birthDate(petDTO.getBirthDate())
                .owner(owner)
                .build();

        Pet savedPet = petService.save(newPet);
        
        // redirect : DB에 넣은 데이터인 Owner에
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/{petId}/edit")
    public String initUpdatePetForm(@PathVariable Long ownerId, @PathVariable Long petId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        Pet pet = petService.findById(petId);
        System.out.println("와 여기임 여기임");
        System.out.println(pet);

        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);

        return "pets/createOrUpdatePetForm";
    }
}
