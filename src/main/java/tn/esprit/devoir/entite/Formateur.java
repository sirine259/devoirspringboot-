package tn.esprit.devoir.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormateur;
    private String nom;
    private String prenom;
    private int tarifHoraire;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="formateur")
    private Set<Formation> formations;
}

