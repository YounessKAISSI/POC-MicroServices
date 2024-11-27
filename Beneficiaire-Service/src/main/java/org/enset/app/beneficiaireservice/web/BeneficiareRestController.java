package org.enset.app.beneficiaireservice.web;

import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.enset.app.beneficiaireservice.services.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiaires")
public class BeneficiareRestController {
    @Autowired
    private BeneficiaireService beneficiaireService;

    @GetMapping
    public List<Beneficiaire> getAllBeneficiaries() {
        return beneficiaireService.getAllBeneficiaries();
    }

    @GetMapping("/{id}")
    public Beneficiaire getBeneficiary(@PathVariable Long id) {
        return beneficiaireService.getBeneficiaryById(id);
    }

    @PostMapping
    public Beneficiaire createBeneficiary(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.createBeneficiary(beneficiaire);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable Long id) {
        beneficiaireService.deleteBeneficiary(id);
    }
}
