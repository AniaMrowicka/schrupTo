package pl.sda.co_na_obiad.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nameOfDish;
    private String execution;

    private int timeOfExecution; // in minutes

    @OneToMany
    private List<Ingredients> listOfIngresients;
}
