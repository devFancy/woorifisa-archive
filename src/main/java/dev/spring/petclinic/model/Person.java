package dev.spring.petclinic.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter // Lombok getter()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class Person extends BaseEntity{

    private String firstName;
    private String lastName;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(Long id, String firstName, String lastName) {

    }
}
