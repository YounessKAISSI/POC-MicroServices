package org.enset.app.beneficiaireservice.services;

import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.enset.app.beneficiaireservice.repositories.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaireService {

    @Autowired
    private BeneficiaireRepository beneficiaireRepository;

    public List<Beneficiaire> getAllBeneficiaries() {
        return beneficiaireRepository.findAll();
    }

    public Beneficiaire getBeneficiaryById(Long id) {
        return beneficiaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Beneficiary not found"));
    }

    public Beneficiaire createBeneficiary(Beneficiaire beneficiaire) {
        return beneficiaireRepository.save(beneficiaire);
    }

    public void deleteBeneficiary(Long id) {
        beneficiaireRepository.deleteById(id);
    }
}
