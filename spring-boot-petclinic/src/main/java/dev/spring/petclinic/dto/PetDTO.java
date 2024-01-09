package dev.spring.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class PetDTO {

    private final String name;

    private final Long type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final LocalDate birthDate;
}
