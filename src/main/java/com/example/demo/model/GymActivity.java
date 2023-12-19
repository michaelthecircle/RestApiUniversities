package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gym_activity")
public class GymActivity {
    @Column(name = "id_gym_activity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short gymActivityId;

    @Column(name = "name_activity")
    private String nameActivity;

    @Column(name = "gym_activity_trainer")
    private String gymActivityTrainer;

    @ManyToOne
    @JoinColumn(name = "fk_id_gym", referencedColumnName = "id_gym")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gym gymOwner;

    public GymActivity(String nameActivity, String gymActivityTrainer, Gym gymOwner) {
        this.nameActivity = nameActivity;
        this.gymActivityTrainer = gymActivityTrainer;
        this.gymOwner = gymOwner;
    }
}