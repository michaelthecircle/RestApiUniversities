package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "laboratory_assistant")
@NoArgsConstructor
public class LaboratoryAssistant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory_assistant", nullable = false)
    private Long idLaboratoryAssistant;


    @Column(name = "hours_in_laboratory_per_week")
    @NotNull
    @Size(max = 40)
    private short hoursInLaboratoryPerWeek;

    @Column(name = "position")
    @NotNull
    private String position;

    @Column(name = "full_name")
    @NotNull
    private String fullName;

    @Column(name = "experience_years")
    @NotNull
    private short experienceYears;

    @ManyToOne
    @JoinColumn(name = "fk_id_laboratory", referencedColumnName = "id_laboratory")
    private Laboratory laboratoryOwner;

    public LaboratoryAssistant(short hoursInLaboratoryPerWeek, String position, String fullName, short experienceYears) {
        this.hoursInLaboratoryPerWeek = hoursInLaboratoryPerWeek;
        this.position = position;
        this.fullName = fullName;
        this.experienceYears = experienceYears;
    }
}