package org.enset.app.beneficiaireservice.services;

import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.enset.app.beneficiaireservice.repositories.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Beneficiaire updateBeneficiary(Beneficiaire beneficiaire) {
        // Vérifier si le bénéficiaire existe déjà
        Optional<Beneficiaire> existingBeneficiary = beneficiaireRepository.findById(beneficiaire.getId());

        if (existingBeneficiary.isPresent()) {
            // Mettre à jour les champs nécessaires
            Beneficiaire beneficiaryToUpdate = existingBeneficiary.get();
            beneficiaryToUpdate.setFirstName(beneficiaire.getFirstName());
            beneficiaryToUpdate.setLastName(beneficiaire.getLastName());
            beneficiaryToUpdate.setType(beneficiaire.getType());
            beneficiaryToUpdate.setRIB(beneficiaire.getRIB());
            // Ajouter ici d'autres champs à mettre à jour

            return beneficiaireRepository.save(beneficiaryToUpdate);
        } else {
            throw new IllegalArgumentException("Le bénéficiaire avec l'ID " + beneficiaire.getId() + " n'existe pas.");
        }
    }

    public void deleteBeneficiary(Long id) {
        Optional<Beneficiaire> existingBeneficiary = beneficiaireRepository.findById(id);

        if (existingBeneficiary.isPresent()) {
            beneficiaireRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Le bénéficiaire avec l'ID " + id + " n'existe pas.");
        }
    }

//    public void deleteBeneficiary(Long id) {
//        beneficiaireRepository.deleteById(id);
//    }
}
