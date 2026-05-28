package com.springdatajpa.demo.model.task;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("BILLABLE")
@Getter
@Setter
@NoArgsConstructor
public class BillableTask extends Task {

    private BigDecimal hourlyRate;

    public BillableTask(String title, java.time.LocalDate dueDate,
                        boolean completed, BigDecimal hourlyRate) {
        super(null, title, dueDate, completed);
        this.hourlyRate = hourlyRate;
    }
}