package com.springdatajpa.demo.model.event;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exhibition extends Event {

    public Exhibition(String title, java.time.LocalDate date, Integer duration,
                      String location, java.util.List<Guest> guests) {
        super(null, title, date, duration, location, guests);
    }
}