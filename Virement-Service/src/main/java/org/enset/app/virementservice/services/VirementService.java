package org.enset.app.virementservice.services;

import org.enset.app.virementservice.dtos.VirementDTO;
import org.enset.app.virementservice.entities.Virement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VirementService {
    List<VirementDTO> getAllVirements();
    VirementDTO getVirementById(Long id);
    Virement createVirement(VirementDTO virementDTO);
    List<VirementDTO> getVirementsByBeneficiaire(Long beneficiaireId);
}
