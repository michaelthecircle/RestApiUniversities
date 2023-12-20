package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@JsonSerialize
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "university")
public class University {
    @Column(name = "id_university")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversity;

    @Column(name = "name", unique = true)
    @NotNull
    private String name;

    @Column(name = "address", unique = true)
    @NotNull
    private String address;

    @Column(name = "rating")
    @NotNull
    @DecimalMin(value = "0", message = "Rating must be greater than or equal to 0")
    @DecimalMax(value = "10", message = "Rating must be less than or equal to 10")
    private double rating;


    @Column(name = "email", unique = true)
    @Email
    @NotNull
    private String email;

    @Column(name = "website", unique = true)
    @NotNull
    private String website;

    @Column(name = "phone_number", unique = true)
    @NotNull
    @Pattern(regexp="^\\+[0-9]{1,3} \\([0-9]{3}\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "Phone number must be in the format +7 (999) 123-45-67")
    private String phoneNumber;

    @Column(name = "government_funding")
    @NotNull
    private boolean hasGovernmentFunding;

    @Column(name = "military_center")
    @NotNull
    private boolean hasMilitaryCenter;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Dormitory> dormitories;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<DiningRoom> diningRooms;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Gym> gyms;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Faculty> faculties;

    public University(String name,
                      String address,
                      double rating,
                      String description,
                      boolean hasMilitaryCenter,
                      boolean hasGovernmentFunding,
                      String website,
                      List<Dormitory> dormitories) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.description = description;
        this.hasMilitaryCenter = hasMilitaryCenter;
        this.hasGovernmentFunding = hasGovernmentFunding;
        this.website = website;
        this.dormitories = dormitories;
    }

    @Override
    public String toString() {
        return "University [id=" + idUniversity + ", name=" + name + ", address=" + address
                + ", government/not=" + hasGovernmentFunding + ", rating =" + rating +
                ", email=" + email + "]";
    }
}
