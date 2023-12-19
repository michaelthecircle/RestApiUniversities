package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "gym")
public class Gym {
    @Column(name = "id_gym")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idGym;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "rating")
    @NotNull
    private double rating;

    @Column(name = "schedule")
    private String schedule;

    @ManyToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private University universityOwner;

    @OneToMany(mappedBy = "gymOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<GymActivity> gymActivities;

    public Gym(String address, double rating, String schedule, University universityOwner) {
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
        this.universityOwner = universityOwner;
    }
}
