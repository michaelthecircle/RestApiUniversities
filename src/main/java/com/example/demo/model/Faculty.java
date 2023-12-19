package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "faculty")
@NoArgsConstructor
@Getter
@Setter
public class Faculty {
    @Id
    @Column(name = "id_faculty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFaculty;

    @Column(name = "name_faculty")
    @NotNull
    private String nameFaculty;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private University universityOwner;

    @OneToMany(mappedBy = "facultyOwner")
    List<Department> departments;

    public Faculty(String nameFaculty, String phoneNumber, String description, List<Department> departments) {
        this.nameFaculty = nameFaculty;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.departments = departments;
    }
}
