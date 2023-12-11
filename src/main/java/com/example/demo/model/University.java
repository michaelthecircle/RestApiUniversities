package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@JsonSerialize
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "university")
public class University {
    @Id
    @Column(name = "id_university")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("name_university") // just to try jsonproperty
    @Column(name = "name_university", unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private float rating;

    @Column(name = "governmental")
    private boolean governmental;

    @Column(name = "email")
    private String email;

    @JsonCreator
    public University(String nameUniversity, String addressUniversity,
                      float rating, boolean gorvernmental, String email) {
        this.name = nameUniversity;
        this.address = addressUniversity;
        this.rating = rating;
        this.governmental = gorvernmental;
        this.email = email;
    }

    @Override
    public String toString() {
        return "University [id=" + id + ", name=" + name + ", address=" + address
                + ", government/not=" + governmental + ", rating =" + rating +
                ", email=" + email + "]";
    }
}
