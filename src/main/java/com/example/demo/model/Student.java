package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Long idStudent;

    @ManyToOne
    @JoinColumn(name = "fk_id_study_group", referencedColumnName = "id_study_group")
    private StudyGroup studyGroupOwner;

    @Column(name = "free_education_cost")
    @NotNull
    private boolean freeEducationCost;

    @Column(name ="student_passing_score")
    @NotNull
    private short studentPassingScore;
}