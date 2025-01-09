package org.enset.app.beneficiaireservice.web;

import org.enset.app.beneficiaireservice.dtos.BeneficiaireDTO;
import org.enset.app.beneficiaireservice.services.BeneficiaireServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiaires")
@CrossOrigin(origins = "http://localhost:4200")
public class BeneficiareRestController {
    @Autowired
    private BeneficiaireServiceImp beneficiaireService;

    @GetMapping
    public List<BeneficiaireDTO> getAllBeneficiaries() {
        return beneficiaireService.getAllBeneficiaries();
    }

    @GetMapping("/{id}")
    public BeneficiaireDTO getBeneficiary(@PathVariable Long id) {
        return beneficiaireService.getBeneficiaryById(id);
    }

    @GetMapping("/search")
    public List<BeneficiaireDTO> searchBeneficiaries(@RequestParam(name = "keyword",defaultValue = "") String keyword) {
        return beneficiaireService.searchBeneficiaries("%" + keyword + "%");
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable Long id) {
        beneficiaireService.deleteBeneficiaryById(id);
    }

    /*@PostMapping
    public Beneficiaire createBeneficiary(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.createBeneficiary(beneficiaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiaire> updateBeneficiary(@PathVariable Long id, @RequestBody Beneficiaire beneficiaire) {
        beneficiaire.setId(id); // S'assurer que l'ID correspond
        Beneficiaire updatedBeneficiary = beneficiaireService.updateBeneficiary(beneficiaire);
        return ResponseEntity.ok(updatedBeneficiary);
    }*/


}
