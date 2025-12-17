package tn.esprit.devoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devoir.entite.Apprenant;

public interface ApprenantRepo extends JpaRepository<Apprenant, Integer> {
    Apprenant findByNomAndPrenom(String a,String b);
}
