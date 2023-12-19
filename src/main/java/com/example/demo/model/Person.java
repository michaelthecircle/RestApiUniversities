package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "person")
@Setter
@Getter
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerson;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

//    @Column(name="role")
//    private String role;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
