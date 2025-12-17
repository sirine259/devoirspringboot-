package tn.esprit.devoir.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import tn.esprit.devoir.entite.Apprenant;
import tn.esprit.devoir.entite.Formateur;
import tn.esprit.devoir.entite.Formation;
import tn.esprit.devoir.service.ITestService;

@RestController
@RequestMapping("/xxxxxxxxxxxxx")
public class MyController {
    @Autowired
    ITestService testService;

    @PostMapping("/add-Apprenant")
    public void addApprenant(@RequestBody Apprenant p) {
        testService.ajouterApprenant(p);
    }

    @PostMapping("/add-Formateur")
    public void addFormateur(@RequestBody Formateur f) {
        testService.ajouterFormateur(f);
    }

    @PostMapping("/addFormationAFormateur/{idFormation}/{idFormateur}")
    public void addFormationAFormateur(@RequestBody Formation formation, @PathVariable("idFormation") Integer idFormation, @PathVariable("idFormateur") Integer idFormateur) {
        testService.ajouterEtAffecterFormationAFormateur(formation, idFormateur);
    }

    @PostMapping("/addApprenantFormation/{idApprenant}/{idFormation}")
    public void addApprenantFormation(@RequestBody Formation formation, @PathVariable("idApprenant") Integer idApprenant, @PathVariable("idFormation") Integer idFormation) {
        testService.AffecterApprenantFormation(idApprenant, idFormation);
    }
    
    @GetMapping("/formateur/{idFormateur}/remuneration")
    public Integer getFormateurRemuneration(
            @PathVariable("idFormateur") Integer idFormateur,
            @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date dateFin) {
        return testService.getFormateurRemunerationByDate(idFormateur, dateDebut, dateFin);
    }
    
    @GetMapping("/formation/{idFormation}/revenu")
    public Integer getFormationRevenu(@PathVariable("idFormation") Integer idFormation) {
        return testService.getRevenuByFormation(idFormation);
    }
}