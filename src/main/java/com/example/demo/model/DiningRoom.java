package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "dining_room")
@NoArgsConstructor
@Setter
@Getter
public class DiningRoom {
    @Column(name = "id_dining_room")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDiningRoom;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private double rating;

    @Column(name = "schedule")
    private String schedule;

    @ManyToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private University universityOwner;

    public DiningRoom(String address, double rating, String schedule, University universityOwner) {
        this.address = address;
        this.rating = rating;
        this.universityOwner = universityOwner;
        this.schedule = schedule;
    }
}
