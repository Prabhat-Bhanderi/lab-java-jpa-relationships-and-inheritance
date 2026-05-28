package com.springdatajpa.demo.model.pr;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
}