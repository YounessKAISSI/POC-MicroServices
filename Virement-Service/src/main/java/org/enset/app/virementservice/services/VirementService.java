package org.enset.app.virementservice.services;

import org.enset.app.virementservice.entities.Virement;
import org.enset.app.virementservice.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VirementService {
    @Autowired
    private VirementRepository virementRepository;

    public List<Virement> getAllVirements() {
        return virementRepository.findAll();
    }

    public Virement getVirementById(Long id) {
        return virementRepository.findById(id).orElseThrow(() -> new RuntimeException("Virement not found"));
    }

    public Virement createVirement(Virement virement) {
        return virementRepository.save(virement);
    }

    public List<Virement> getVirementsByBeneficiaire(Long beneficiaireId) {
        return virementRepository.findByBeneficiaireId(beneficiaireId);
    }
}
