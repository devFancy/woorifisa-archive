package dev.spring.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/*
 * Field Summary
 * String name;
 * LocalDate birthDate; // 컬럼명 birth_date
 *
 * pet은 한 명의 Owner를 가지고 있다.
 * Owner owner;
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Builder
    public Pet(Long id, String name, PetType petType, LocalDate birthDate, Owner owner) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
        this.owner = owner;
    }
}