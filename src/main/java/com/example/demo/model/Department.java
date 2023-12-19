package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id_department")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDepartment;

    @Column(name = "name_department")
    private String nameDepartment;

    @ManyToOne
    @JoinColumn(name = "fk_id_faculty", referencedColumnName = "id_faculty")
    private Faculty facultyOwner;

    @OneToMany(mappedBy = "departmentOwner", cascade = CascadeType.PERSIST)
    private List<EducationalDirection> educationalDirections;

    @OneToMany(mappedBy = "laboratoryOwner")
    private List<Laboratory>laboratories;


    public Department(Faculty facultyOwner, List<EducationalDirection> educationalDirections) {
        this.educationalDirections =  educationalDirections;
    }
    @Transient
    public int getEducationalDirectionsCount() {
        return (educationalDirections.size());
    }



}
