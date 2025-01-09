package org.enset.app.virementservice.services;

import org.enset.app.virementservice.dtos.VirementDTO;
import org.enset.app.virementservice.entities.Virement;
import org.enset.app.virementservice.mappers.VirementMapperImp;
import org.enset.app.virementservice.repositories.VirementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VirementServiceImp implements VirementService{

    private final VirementRepository virementRepository;
    private final VirementMapperImp dtoMapper;

    public VirementServiceImp(VirementRepository virementRepository, VirementMapperImp dtoMapper) {
        this.virementRepository = virementRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<VirementDTO> getAllVirements() {
        List<Virement> virements = virementRepository.findAll();
        return virements.stream().map(dtoMapper::fromVirement).collect(Collectors.toList());
    }

    @Override
    public VirementDTO getVirementById(Long id) {
        Virement virement = virementRepository.findById(id).orElseThrow(() -> new RuntimeException("Beneficiary not found"));
        return dtoMapper.fromVirement(virement);
    }

    @Override
    public Virement createVirement(VirementDTO virementDTO) {
        Virement virement = dtoMapper.fromVirementDTO(virementDTO);
        return virementRepository.save(virement);
    }

    @Override
    public List<VirementDTO> getVirementsByBeneficiaire(Long beneficiaireId) {
        List<Virement> virements = virementRepository.findByBeneficiaireId(beneficiaireId);
        return virements.stream().map(dtoMapper::fromVirement).collect(Collectors.toList());
    }


}
