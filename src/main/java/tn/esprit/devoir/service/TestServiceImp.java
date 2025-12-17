package tn.esprit.devoir.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.devoir.repository.*;
import tn.esprit.devoir.entite.*;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TestServiceImp implements ITestService {
    ApprenantRepo apprenantRepo;
    FormationRepo formationRepo;
    FormateurRepo formateurRepo;

    @Override
    public void ajouterApprenant(Apprenant apprenant) {
        apprenantRepo.save(apprenant);
    }

    @Override
    public void ajouterFormateur(Formateur formateur) {
        formateurRepo.save(formateur);
    }

    @Override
    @Transactional
    public void ajouterEtAffecterFormationAFormateur(Formation formation, Integer idFormateur) {
        Formateur formateur = formateurRepo.findById(idFormateur).orElse(null);
        formation.setFormateur(formateur);
        formateur.getFormations().add(formation);
        formationRepo.save(formation);
    }

    @Override
    public void getNbrApprenatByFormation() {

    }

    @Override
    public int getRevenuByFormation(Integer idFormation) {
        Formation formation = formationRepo.findById(idFormation).orElse(null);
        if (formation != null) {
            int nbrApprenants = formation.getApprenants() != null ? formation.getApprenants().size() : 0;
            return nbrApprenants * formation.getFrais();
        }
        return 0;
    }
    
    @Override
    public Integer getFormateurRemunerationByDate(Integer idFormateur, java.util.Date dateDebut, java.util.Date dateFin) {
        Formateur formateur = formateurRepo.findById(idFormateur).orElse(null);
        if (formateur == null) {
            return 0;
        }
        
        return formateur.getFormations().stream()
                .filter(formation -> !formation.getDateDebut().before(dateDebut) && !formation.getDateFin().after(dateFin))
                .mapToInt(formation -> formation.getNbrHeures() * formateur.getTarifHoraire())
                .sum();
    }

    @Override
    public void ajouterEtAffecterFormation(Formation f, Integer fr) {

    }

    @Override
    public void ajouterEtAffecterApprenantFormation(Formation f) {

    }

    @Override
    public void AffecterApprenantFormation(Integer idApprenant, Integer idFormation) {
        Apprenant apprenant = apprenantRepo.findById(idApprenant).orElse(null);
        Formation formation = formationRepo.findById(idFormation).orElse(null);
        formation.setApprenant(apprenant);
        apprenant.getFormations().add(formation);
        formationRepo.save(formation);
    }

    @Scheduled(fixedRate = 3000)
    @Override
    public void getNbrApprenantByFormation() {
        List<Formation> formations = formationRepo.findAll();
        for (Formation f : formations) {
            log.info("Formation " + f.getNbrApprenant());
        }
    }}


