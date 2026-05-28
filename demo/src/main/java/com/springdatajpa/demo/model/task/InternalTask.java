package com.springdatajpa.demo.model.task;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("INTERNAL")
@Getter
@Setter
@NoArgsConstructor
public class InternalTask extends Task {

    public InternalTask(String title, java.time.LocalDate dueDate, boolean completed) {
        super(null, title, dueDate, completed);
    }
}