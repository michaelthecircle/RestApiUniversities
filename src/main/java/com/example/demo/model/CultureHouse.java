package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "culture_house")
public class CultureHouse {
    @Column(name = "id_culture_house")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCultureHouse;
    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private double rating;

    @Column(name = "schedule")
    private String schedule;

    @OneToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    private University universityOwner;

    @OneToMany(mappedBy = "cultureHouseOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CultureHouseActivity> cultureHouseActivities;
    public CultureHouse(String address, double rating, String schedule, University universityOwner) {
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
        this.universityOwner = universityOwner;
    }
}