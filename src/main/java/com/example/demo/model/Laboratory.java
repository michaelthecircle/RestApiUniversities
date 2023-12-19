package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "laboratory")
@NoArgsConstructor
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory", nullable = false)
    private Long idLaboratory;

    @Column(name = "laboratory_count_places")
    private short laboratoryCountPlaces;

    @Column(name = "laboratory_name")
    @NotNull
    private String laboratoryName;

    @ManyToOne
    @JoinColumn(name = "fk_id_department", referencedColumnName = "id_department")
    private Department laboratoryOwner;

    @OneToMany(mappedBy = "laboratoryOwner")
    private List<LaboratoryAssistant> laboratoryAssistants;


    public Laboratory(short laboratoryCountPlaces, String laboratoryName) {
        this.laboratoryCountPlaces = laboratoryCountPlaces;
        this.laboratoryName = laboratoryName;
    }
}