package com.springdatajpa.demo;

import com.springdatajpa.demo.model.event.*;
import com.springdatajpa.demo.model.nurse.*;
import com.springdatajpa.demo.model.pr.*;
import com.springdatajpa.demo.model.task.*;
import com.springdatajpa.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContactRepository contactRepo;
    private final AssociationRepository associationRepo;
    private final EventRepository eventRepo;
    private final TaskRepository taskRepo;

    public DataLoader(ContactRepository contactRepo,
                      AssociationRepository associationRepo,
                      EventRepository eventRepo,
                      TaskRepository taskRepo) {
        this.contactRepo = contactRepo;
        this.associationRepo = associationRepo;
        this.eventRepo = eventRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public void run(String... args) {

        // ── 1. PR Contacts ──────────────────────────────────────────────
        contactRepo.save(new Contact(null, "Ironhack", "Lead Instructor",
                new Name("Dr.", "Ana", "M.", "García")));
        contactRepo.save(new Contact(null, "TechCorp", "CEO",
                new Name("Mr.", "John", null, "Smith")));
        contactRepo.save(new Contact(null, "HealthPlus", "Director",
                new Name("Mrs.", "Laura", "A.", "Müller")));

        System.out.println("✅ Contacts saved.");

        // ── 2. Nurse Association ─────────────────────────────────────────
        Association association = new Association();
        association.setName("Nurse Association of Spain");

        String[] districtNames = {"Madrid", "Barcelona", "Valencia",
                "Seville", "Bilbao", "Málaga", "Zaragoza"};

        List<Division> divisions = new java.util.ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Member president = new Member(null, "President " + (i + 1),
                    MemberStatus.ACTIVE, LocalDate.now().plusMonths(6));
            Member member1 = new Member(null, "Member A-" + (i + 1),
                    MemberStatus.ACTIVE, LocalDate.now().plusMonths(3));
            Member member2 = new Member(null, "Member B-" + (i + 1),
                    MemberStatus.LAPSED, LocalDate.now().minusMonths(1));

            Division division = new Division(null,
                    "Division " + (i + 1),
                    districtNames[i],
                    president,
                    List.of(member1, member2));
            divisions.add(division);
        }
        association.setDivisions(divisions);
        associationRepo.save(association);

        System.out.println("✅ Association with 7 divisions saved.");

        // ── 3. Events ────────────────────────────────────────────────────
        Guest g1 = new Guest(null, "Alice", GuestStatus.ATTENDING);
        Guest g2 = new Guest(null, "Bob", GuestStatus.NO_RESPONSE);
        Guest g3 = new Guest(null, "Carlos", GuestStatus.NOT_ATTENDING);

        Speaker s1 = new Speaker(null, "Dr. Rivera", 45);
        Speaker s2 = new Speaker(null, "Prof. Kim", 30);

        Conference conf = new Conference(
                "Tech Summit 2025",
                LocalDate.of(2025, 9, 15),
                480,
                "Madrid Convention Center",
                List.of(g1, g2),
                List.of(s1, s2));
        eventRepo.save(conf);

        Exhibition expo = new Exhibition(
                "Art & Science Expo",
                LocalDate.of(2025, 10, 5),
                360,
                "Barcelona Pavilion",
                List.of(g3));
        eventRepo.save(expo);

        System.out.println("✅ Events saved.");

        // ── 4. Tasks (Optional) ──────────────────────────────────────────
        taskRepo.save(new BillableTask("Design API", LocalDate.now().plusDays(7),
                false, new BigDecimal("120.00")));
        taskRepo.save(new BillableTask("Write tests", LocalDate.now().plusDays(3),
                false, new BigDecimal("95.50")));
        taskRepo.save(new InternalTask("Update docs", LocalDate.now().plusDays(5), false));
        taskRepo.save(new InternalTask("Team meeting prep", LocalDate.now().plusDays(1), true));

        System.out.println("✅ Tasks saved.");
    }
}
