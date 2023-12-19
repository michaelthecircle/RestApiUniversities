package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "study_group")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_study_group", nullable = false)
    private Long idStudyGroup;

    @ManyToOne
    @JoinColumn(name = "fk_id_educational_direction", referencedColumnName = "id_educational_direction")
    private EducationalDirection studyGroupOwner;

    @OneToMany(mappedBy = "studyGroupOwner")
    private List<Student> students;
}