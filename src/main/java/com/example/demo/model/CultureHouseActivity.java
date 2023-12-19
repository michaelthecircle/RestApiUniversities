package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "culture_house_activity")
public class CultureHouseActivity {
    @Column(name = "id_culture_house_activity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idCultureHouseActivity;

    @Column(name = "name_activity")
    @NotNull
    private String nameActivity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_id_culture_house", referencedColumnName = "id_culture_house")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CultureHouse cultureHouseOwner;

    public CultureHouseActivity(String nameActivity, String description, CultureHouse cultureHouseOwner) {
        this.nameActivity = nameActivity;
        this.cultureHouseOwner = cultureHouseOwner;
        this.description = description;
    }
}
