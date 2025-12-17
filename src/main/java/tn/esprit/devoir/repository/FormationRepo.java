package tn.esprit.devoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devoir.entite.Formation;

public interface FormationRepo extends JpaRepository<Formation, Integer> {

}
