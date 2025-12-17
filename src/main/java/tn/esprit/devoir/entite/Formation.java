package tn.esprit.devoir.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormation;
    private String titre;
    private Date dateFin;
    private Date dateDebut;
    private int nbrHeures;
    private int nbrMaxParticipant;
    private int frais;
    @Enumerated(EnumType.STRING)

    private Niveau niveau;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Apprenant> Apprenants;
    @ManyToOne
    Formateur formateur;

    public void setApprenant(Apprenant apprenant) {
    }

    public String getNbrApprenant() {
        return "";
    }


    public enum Niveau{
        Debutant,Informediaire,Avance
    }
}

