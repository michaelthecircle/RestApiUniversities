package com.example.demo.model;

import com.example.demo.model.University;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "dormitory")
public class Dormitory {
    @Id
    @Column(name = "id_dormitory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dormitoryId;

    @Column(name = "address")
    private String address;

    @Column(name = "available_places")
    @NotNull
    @Size
    private short availablePlaces;

    @Column(name = "all_places")
    @NotNull
    @Size
    private short allPlaces;

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private DormitoryRoomsType dormitoryRoomsType;

    @Column(name = "rating")
    private double rating;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private University universityOwner;

    @JsonCreator
    public Dormitory(String address, short availablePlaces, short allPlaces, DormitoryRoomsType dormitoryRoomsType, double rating, String description, University universityOwner) {
        this.address = address;
        this.availablePlaces = availablePlaces;
        this.allPlaces = allPlaces;
        this.dormitoryRoomsType = dormitoryRoomsType;
        this.rating = rating;
        this.description = description;
        this.universityOwner = universityOwner;
    }
}