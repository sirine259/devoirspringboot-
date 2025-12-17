package tn.esprit.devoir.service;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.devoir.entite.Apprenant;
import tn.esprit.devoir.entite.Formation;
import tn.esprit.devoir.entite.Formateur;

import java.util.List;

public interface ITestService {

    public void ajouterFormateur (Formateur formateur);
    public void ajouterApprenant (Apprenant apprenant);
    public void AffecterApprenantFormation(Integer idApprenant, Integer idFormation);
    public void ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur);
    public void getNbrApprenatByFormation();
    public int getRevenuByFormation(Integer idFormation);


    void ajouterEtAffecterFormation(Formation f, Integer fr);

    void ajouterEtAffecterApprenantFormation(Formation f);

    @Scheduled(fixedRate = 3000)
    void getNbrApprenantByFormation();
    
    public Integer getFormateurRemunerationByDate(Integer idFormateur, java.util.Date dateDebut, java.util.Date dateFin);
}
