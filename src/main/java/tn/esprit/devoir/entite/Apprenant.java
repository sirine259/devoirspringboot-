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
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idApprenant;
    private String nom;
    private String prenom;
    private int telephone;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Formation> formations;

    }

