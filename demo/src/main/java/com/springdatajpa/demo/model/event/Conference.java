package com.springdatajpa.demo.model.event;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Conference extends Event {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "conference_speakers",
        joinColumns = @JoinColumn(name = "conference_id"),
        inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;

    public Conference(String title, java.time.LocalDate date, Integer duration,
                      String location, List<Guest> guests, List<Speaker> speakers) {
        super(null, title, date, duration, location, guests);
        this.speakers = speakers;
    }
}